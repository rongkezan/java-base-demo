package com.demo;

/**
 * Lambda表达式
 *  1. 拷贝小括号，写死右箭头，落地大括号
 *  2. @FunctionalInterface
 *  3. default
 *  4. static
 *  5. 只支持函数式接口，即一个接口类只有一个接口方法
 */
@FunctionalInterface
interface Foo{
    default void sayHello(){
        System.out.println("Hello World");
    }

    static int mul(int x, int y){
        return x * y;
    }

    static int div(int x, int y){
        return x / y;
    }

    int add(int x, int y);
}
public class LambdaExpressDemo {
    public static void main(String[] args) {
        Foo foo = (x, y) -> {return x + y;};

        System.out.println(foo.add(1, 2));

        System.out.println(Foo.div(10, 2));
    }
}
