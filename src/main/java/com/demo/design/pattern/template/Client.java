package com.demo.design.pattern.template;

abstract class SoyBeanMilk {
    public abstract void addMaterial();

    protected final void make() {
        if (needMaterial()){
            addMaterial();
        }
        beat();
        box();
    }

    protected void beat() {
        System.out.println("打浆");
    }

    protected void box(){
        System.out.println("打包");
    }

    protected boolean needMaterial(){
        return true;
    }
}

class RedBeanSoyBeanMilk extends SoyBeanMilk{
    @Override
    public void addMaterial() {
        System.out.println("加入上好的红豆作为配料");
    }
}

class PeanutSoyBeanMilk extends SoyBeanMilk{
    @Override
    public void addMaterial() {
        System.out.println("加入上好的花生作为配料");
    }
}

class PureSoyBeanMilk extends SoyBeanMilk{

    @Override
    public void addMaterial() {

    }

    @Override
    protected boolean needMaterial() {
        return false;
    }
}

public class Client {
    public static void main(String[] args) {
        System.out.println("----- 制作红豆豆浆 -----");
        SoyBeanMilk redBeanSoyBeanMilk = new RedBeanSoyBeanMilk();
        redBeanSoyBeanMilk.make();

        System.out.println("----- 制作花生豆浆 -----");
        SoyBeanMilk peanutSoyBeanMilk = new PeanutSoyBeanMilk();
        peanutSoyBeanMilk.make();

        System.out.println("----- 制作纯豆浆 -----");
        SoyBeanMilk pureSoyBeanMilk = new PureSoyBeanMilk();
        pureSoyBeanMilk.make();
    }
}
