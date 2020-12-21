package com.demo.design.pattern.builder;

import lombok.Data;

/**
 * @author keith
 */
@Data
public class User {
    private String name;
    private Integer age;

    private User(Builder b) {
        this.name = b.name;
        this.age = b.age;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String name;
        private Integer age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
