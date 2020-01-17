package com.demo.java8;

public class FunctionReferenceDemo2 {
    public static void main(String[] args) {
        // 引用静态方法
        IFunction<String, Integer> fun = String::valueOf;
        String str = fun.convert(100);  //String str = String.valueOf(100)
        System.out.println(str.length());
    }

    // R表示方法引用的返回值类型，P表示参数类型
    @FunctionalInterface
    interface IFunction<R, P>{
        R convert (P param);
    }
}
