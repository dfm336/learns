package com.dfm.app.guava.graph;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

/**
 * @Author:fengming.dai
 */
public class Test {
    public static void main(String[] args) {
        //建立一个 有向 图
        GraphBuilder<Object> graph = GraphBuilder.directed();

        MutableValueGraph<Object, Object> build = ValueGraphBuilder.directed().build();
    }
}
