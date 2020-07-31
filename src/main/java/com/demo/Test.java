package com.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Test {

    @Data
    @AllArgsConstructor
    static class User{
        private String username;

        private String password;

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            User user = (User) object;
            return Objects.equals(username, user.username) &&
                    Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, password);
        }
    }

    public static void main(String[] args) {
        User test1 = new User("test1", "123");
        User test2 = new User("test1", "123");
        System.out.println(test1.equals(test2));
        HashSet<User> users = new HashSet<>();
        users.add(test1);
        users.add(test2);
        System.out.println(users);
    }
}
