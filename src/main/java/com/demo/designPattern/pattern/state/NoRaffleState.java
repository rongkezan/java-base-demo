package com.demo.designPattern.pattern.state;

public class NoRaffleState implements State {

    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功，您可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖哦");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("当前状态不能发放奖品");
    }
}
