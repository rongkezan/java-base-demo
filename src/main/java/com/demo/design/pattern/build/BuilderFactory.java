package com.demo.design.pattern.build;

import lombok.Data;

/**
 * 建造者模式(Builder)
 *  1. 如果类的构造器或静态工厂中有多个参数，设计这样的类时，最好使用Builder模式，特别是当大多数参数都是可选的时候
 *  2. 如果现在不能确定参数的个数，最好一开始就使用Builder模式
 */

public class BuilderFactory{
    public static void main(String[] args) {
        Outer outer = new Outer.Builder().withName("Keith").withAge(24).build();
        System.out.println(outer);
    }

    @Data
    private static class Outer {
        private String name;
        private Integer age;

        private static final class Builder{
            private String name;
            private Integer age;

            public Builder(){

            }

            public Builder withName(String name){
                this.name = name;
                return this;
            }

            public Builder withAge(Integer age){
                this.age = age;
                return this;
            }

            public Outer build(){
                return new Outer(this);
            }
        }

        private Outer(Builder b){
            this.name = b.name;
            this.age = b.age;
        }
    }
}


