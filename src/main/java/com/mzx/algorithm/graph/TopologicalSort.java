package com.mzx.algorithm.graph;

import java.util.Stack;

/**
 * 拓扑排序
 */
public class TopologicalSort {
    private Stack<Integer> order;

    public TopologicalSort(DirectedGraph graph) {
        DirectedCycle cycle = new DirectedCycle(graph);
        if (!cycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
            this.order = depthFirstOrder.reversePost();
        }
    }

    public boolean isCycle() {
        return this.order == null;
    }

    public Stack<Integer> order() {
        return this.order;
    }
}
