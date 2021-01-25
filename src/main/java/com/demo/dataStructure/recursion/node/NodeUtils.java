package com.demo.dataStructure.recursion.node;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author keith
 */
public class NodeUtils {

    public static Node getNode(List<Node> nodes, String path){
        for (Node node : nodes) {
            if (StringUtils.equals(node.getPath(), path)){
                return node;
            } else {
                // 递归找子节点
                Node childNode = getNode(node.getChildren(), path);
                if (childNode != null)
                    return childNode;
            }
        }
        return null;
    }
}
