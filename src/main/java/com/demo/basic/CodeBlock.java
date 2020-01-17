package com.demo.basic;

import lombok.Data;

/**
 * 构造代码块
 *  1. 构造代码块的作用是给对象进行初始化。
 *  2. 对象一建立就运行构造代码块了，而且优先于构造函数执行。
 *     这里要强调一下，有对象建立，才会运行构造代码块，类不能调用构造代码块的，而且构造代码块与构造函数的执行顺序是前者先于后者执行。
 *  3. 构造代码块与构造函数的区别是：构造代码块是给所有对象进行统一初始化，而构造函数是给对应的对象初始化，因为构造函数是可以多个的，
 *     运行哪个构造函数就会建立什么样的对象，但无论建立哪个对象，都会先执行相同的构造代码块。也就是说，构造代码块中定义的是不同对象共性的初始化内容。
 *
 * 静态代码块
 * 1. 它是随着类的加载而执行，只执行一次，并优先于主函数。具体说，静态代码块是由类调用的。类调用时，先执行静态代码块，然后才执行主函数的。
 * 2. 静态代码块其实就是给类初始化的，而构造代码块是给对象初始化的。
 * 3. 静态代码块中的变量是局部变量，与普通函数中的局部变量性质没有区别。
 * 4. 一个类中可以有多个静态代码块
 */
public class CodeBlock {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println("num = " + MyClass.num);
        System.out.println("count = " + myClass.getCount());
    }

    @Data
    private static class MyClass{
        private static int num;
        private int count;
        static{
            num = 20;
            System.out.println("执行静态代码块1");
        }
        {
            this.count = 10;
            System.out.println("执行构造代码块1");
        }

        public MyClass(){
            System.out.println("执行构造函数1");
        }
    }
}
