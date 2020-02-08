package com.demo.designPattern.pattern.state;

/**
 * 发放奖品状态
 */
public class DispenseState implements State {

    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0) {
            System.out.println("恭喜中奖了");
            activity.setState(activity.getNoRaffleState());
        } else {
            System.out.println("很遗憾，奖品发送完了");
            activity.setState(activity.getDispenseOutState());
        }
    }
}
