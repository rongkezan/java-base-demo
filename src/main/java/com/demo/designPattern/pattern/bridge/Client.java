package com.demo.designPattern.pattern.bridge;

public class Client {
    public static void main(String[] args) {
        new FoldedPhone(new Vivo()).open();

        new SlidePhone(new Vivo()).close();

        new FoldedPhone(new XiaoMi()).call();

        new SlidePhone(new XiaoMi()).open();
    }
}
