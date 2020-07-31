package com.demo.design.pattern.share;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 不通过new的方式在地图上创建多个树
 * Create a map, there has a lot of trees in map.
 * we don't need new them, we can use share pattern to do it.
 */

@Data
class Tree {
    private final String name;
    private final String data;
}

@Getter
class TreeNode {
    private int x;
    private int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        System.out.println(tree.getName() + "\t被创建，描述:" + tree.getData());
        this.x = x;
        this.y = y;
        this.tree = tree;
    }
}

class TreeFactory {
    private static Map<String, Tree> map = new HashMap<>();

    public static Tree getTree(String name, String data) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        Tree tree = new Tree(name, data);
        map.put(name, tree);
        return tree;
    }
}

public class Client {
    public static void main(String[] args) {
        new TreeNode(3,4, TreeFactory.getTree("xxx", "description of xxx"));
        new TreeNode(4,5, TreeFactory.getTree("yyy", "description of yyy"));
    }
}