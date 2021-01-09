package com.demo.juc.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CountDownLatch;

/**
 * 被减到零才放行，否则等待
 * 默认需要指定一个
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1; i <= 6; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国被灭");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ********秦帝国，一统华夏");
    }

    /**
     * 6个同学上自习，班长关门，所以需要最后走
     */
    public static void closeDoor() throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1; i <= 6; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ********班长最后关门走人");
    }

    /**
     * 枚举类的使用
     */
    @Getter
    @AllArgsConstructor
    private enum CountryEnum {
        ONE(1, "齐"),
        TWO(2, "楚"),
        THREE(3, "燕"),
        OUR(4, "赵"),
        FIVE(5, "魏"),
        SIX(6, "韩");

        private Integer retCode;
        private String retMessage;

        public static CountryEnum forEachCountryEnum(int index){
            CountryEnum[] myArray = CountryEnum.values();
            for (CountryEnum element : myArray) {
                if(index == element.getRetCode()){
                    return element;
                }
            }
            return null;
        }
    }
}
