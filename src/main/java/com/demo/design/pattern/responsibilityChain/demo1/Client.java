package com.demo.design.pattern.responsibilityChain.demo1;

import com.demo.design.pattern.responsibilityChain.demo1.filter.FourFilter;
import com.demo.design.pattern.responsibilityChain.demo1.filter.OneFilter;
import com.demo.design.pattern.responsibilityChain.demo1.filter.ThreeFilter;
import com.demo.design.pattern.responsibilityChain.demo1.filter.TwoFilter;

/**
 * 使用责任链模式实现过滤器
 *
 * 一串1-9的数字依次进行过滤
 * 使用两个链条进行串联
 */
public class Client {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setContent("123456789");
        FilterChain fc = new FilterChain();
        FilterChain fc2 = new FilterChain();
        fc.add(new OneFilter()).add(new TwoFilter());
        fc2.add(new ThreeFilter()).add(new FourFilter());
        fc.add(fc2);
        fc.doFilter(msg);
        System.out.println(msg);
    }
}
