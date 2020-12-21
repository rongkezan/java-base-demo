package com.demo.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 点结构描述
 * @author keith
 */
public class Node {
    /* 编号 */
    private int value;
    /* 入度 */
    private int in;
    /* 出度 */
    private int out;
    /* 直接邻居 */
    private List<Node> nexts;
    /* 边 */
    private List<Edge> edges;

    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
