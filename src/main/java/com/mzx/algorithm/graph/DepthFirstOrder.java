package com.mzx.algorithm.graph;

import java.util.Stack;

/**
 * 深度优先排序
 */
public class DepthFirstOrder {
    /**
     * 存储搜索状态
     */
    private boolean[] marked;
    /**
     * 存储顶点序列
     */
    private Stack<Integer> reversePost;

    public DepthFirstOrder(DirectedGraph graph) {
        this.marked = new boolean[graph.V()];
        this.reversePost = new Stack<>();
        for (int i = 0; i < graph.V(); i++) {
            dfs(graph, i);
        }
    }

    /**
     * 深度优先搜索
     *
     * @param graph 图
     * @param v     当前顶点
     */
    private void dfs(DirectedGraph graph, int v) {
        if (this.marked[v]) {
            return;
        }
        this.marked[v] = true;
        for (Integer w : graph.adj(v)) {
            dfs(graph, w);
        }
        this.reversePost.push(v);
    }

    /**
     * 获取顶点序列
     *
     * @return 顶点序列
     */
    public Stack<Integer> reversePost() {
        return this.reversePost;
    }
}
