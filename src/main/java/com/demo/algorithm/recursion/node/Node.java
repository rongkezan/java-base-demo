package com.demo.algorithm.recursion.node;

import lombok.Data;

import java.util.List;

/**
 * @author keith
 */
@Data
public class Node {

    private String path;

    private String value;

    private List<Node> children;

    public Node(String path, List<Node> children){
        this.path = path;
        this.children = children;
    }
}
