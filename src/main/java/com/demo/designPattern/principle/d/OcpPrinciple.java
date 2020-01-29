package com.demo.designPattern.principle.d;

/**
 * 开闭原则: 1. 一个软件实体如类，模块和函数应该对拓展开放（提供方），对修改关闭（使用方）。
 */
abstract class Shape{
    public abstract void draw();
}

class Rectangle extends Shape{
    @Override
    public void draw() {
        System.out.println("我是三角形");
    }
}

class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("我是圆形");
    }
}

class GraphicEditor{
    public void draw(Shape s){
        s.draw();
    }
}

public class OcpPrinciple {
    public static void main(String[] args) {
        GraphicEditor ge = new GraphicEditor();
        ge.draw(new Rectangle());
        ge.draw(new Circle());
    }
}
