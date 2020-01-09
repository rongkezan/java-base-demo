package com.demo.java8;

import java.time.*;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("当前时间\t" + currentDateTime);

        Duration duration = Duration.ofDays(2).plus(Duration.ofHours(2).plus(Duration.ofMinutes(3)));
        System.out.println("加2天2小时3分钟\t" + currentDateTime.plus(duration));

        Period period = Period.of(1, 2, 3);
        System.out.println("加1年2月3天\t" + currentDateTime.plus(period));
    }
}
