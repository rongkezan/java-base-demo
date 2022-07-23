package com.demo.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 漏斗算法
 * Funnel 对象的 make_space 方法是漏斗算法的核心，其在每次灌水前都会被调用以触发
 * 漏水，给漏斗腾出空间来。能腾出多少空间取决于过去了多久以及流水的速率。Funnel 对象
 * 占据的空间大小不再和行为的频率成正比，它的空间占用是一个常量。
 * 问题来了，分布式的漏斗算法该如何实现？能不能使用 Redis 的基础数据结构来搞定？
 * 我们观察 Funnel 对象的几个字段，我们发现可以将 Funnel 对象的内容按字段存储到一
 * 个 hash 结构中，灌水的时候将 hash 结构的字段取出来进行逻辑运算后，再将新值回填到
 * hash 结构中就完成了一次行为频度的检测。
 * 但是有个问题，我们无法保证整个过程的原子性。从 hash 结构中取值，然后在内存里
 * 运算，再回填到 hash 结构，这三个过程无法原子化，意味着需要进行适当的加锁控制。而
 * 一旦加锁，就意味着会有加锁失败，加锁失败就需要选择重试或者放弃。
 * 如果重试的话，就会导致性能下降。如果放弃的话，就会影响用户体验。同时，代码的
 * 复杂度也跟着升高很多。这真是个艰难的选择，我们该如何解决这个问题呢？Redis-Cell 救
 * 星来了！
 *
 * @author keith
 */
public class FunnelRateLimiter {

    private final Map<String, Funnel> funnels = new HashMap<>();

    public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
        String key = String.format("%s:%s", userId, actionKey);
        Funnel funnel = funnels.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);
            funnels.put(key, funnel);
        }
        return funnel.watering(1); // 需要 1 个 quota
    }

    static class Funnel {
        private int capacity;
        private float leakingRate;
        private int leftQuota;
        private long leakingTs;

        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            this.leftQuota = capacity;
            this.leakingTs = System.currentTimeMillis();
        }

        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long deltaTs = nowTs - leakingTs;
            int deltaQuota = (int) (deltaTs * leakingRate);
            if (deltaQuota < 0) { // 间隔时间太长，整数数字过大溢出
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }
            if (deltaQuota < 1) { // 腾出空间太小，最小单位是 1
                return;
            }
            this.leftQuota += deltaQuota;
            this.leakingTs = nowTs;
            if (this.leftQuota > this.capacity) {
                this.leftQuota = this.capacity;
            }
        }

        boolean watering(int quota) {
            makeSpace();
            if (this.leftQuota >= quota) {
                this.leftQuota -= quota;
                return true;
            }
            return false;
        }
    }
}
