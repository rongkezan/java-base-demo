package com.demo.design.pattern.visitor;

/**
 * @author keith
 */
public class Client {
    public static void main(String[] args) {
        DataView dataView = new DataView();
        System.out.println("家⻓视⻆访问：");
        dataView.show(new Parent());
        System.out.println("\n校⻓视⻆访问：");
        dataView.show(new Principal());
    }
}
