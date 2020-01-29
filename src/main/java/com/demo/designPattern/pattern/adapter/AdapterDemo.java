package com.demo.designPattern.pattern.adapter;

public class AdapterDemo {
    static public class Voltage220 {
        public int output220(){
            int src = 220;
            System.out.println("电压 = " + src);
            return src;
        }
    }

    interface Voltage5 {
        int output5();
    }

    static class VoltageAdapter implements Voltage5 {

        private static Voltage220 voltage220;

        public VoltageAdapter(){
            voltage220 = new Voltage220();
        }

        @Override
        public int output5() {
            int src = voltage220.output220();
            int dst = src / 44;
            return dst;
        }
    }

    static class Phone {
        public void charging(Voltage5 voltage5){
            if (voltage5.output5() == 5){
                System.out.println("电压为5V，可以充电");
            } else if (voltage5.output5() > 5){
                System.out.println("电压大于5V，无法充电");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- 类适配器模式 ---");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
