package com.demo.dataStructure.recursion.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author keith
 */
public class Client {
    public static void main(String[] args) {
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        Node node = new Node("1", list1);
        list1.add(new Node("2", list2));
        list2.add(new Node("3", new ArrayList<>()));
        System.out.println(node);
        Node node1 = NodeUtils.getNode(Collections.singletonList(node), "3");
        System.out.println(node1);
    }
}
