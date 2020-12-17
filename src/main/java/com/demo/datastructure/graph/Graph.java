package com.demo.datastructure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author keith
 */
public class Graph {
    public Map<Integer, Node> nodee;
    public Set<Edge> edges;

    public Graph(){
        nodee = new HashMap<>();
        edges = new HashSet<>();
    }
}
