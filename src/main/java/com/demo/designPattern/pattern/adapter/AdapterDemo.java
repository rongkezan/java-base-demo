package com.demo.designPattern.pattern.adapter;

/**
 * 类适配器模式
 */
public class AdapterDemo {
    static public class Voltage220 {
        private int srcVoltage = 220;
        public int output220(){
            System.out.println("电压 = " + srcVoltage);
            return srcVoltage;
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
            return voltage220.output220() / 44;
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
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
