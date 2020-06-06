package com.mzx.algorithm.graph;

import java.util.Stack;

/**
 * 深度优先路径搜索
 */
public class DepthFirstPaths {
    /**
     * 标记顶点是否已被搜索
     */
    private boolean[] marked;
    /**
     * 起点
     */
    private int s;
    /**
     * 标识起点到当前顶点路径上的最后一个顶点
     */
    private int[] edgeTo;

    /**
     * 构造方法
     *
     * @param graph 图
     * @param s     搜索顶点
     */
    public DepthFirstPaths(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.s = s;
        this.edgeTo = new int[graph.V()];
        dfs(graph, s);
    }

    /**
     * 深度优先搜索
     *
     * @param graph 图
     * @param v     当前顶点
     */
    private void dfs(Graph graph, int v) {
        this.marked[v] = true;
        graph.adj(v).forEach(w -> {
            if (!this.marked[w]) {
                this.edgeTo[w] = v;
                dfs(graph, w);
            }
        });
    }

    /**
     * 判断 v 顶点与起点之间是否存在路径
     *
     * @param v 顶点
     * @return true / false;
     */
    public boolean hasPath(int v) {
        return this.marked[v];
    }

    /**
     * 找出从起点到顶点 v 的路径
     *
     * @param v 顶点
     * @return 路径栈
     */
    public Stack<Integer> pathTo(int v) {
        if (!hasPath(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int x = v;
        stack.push(x);
        while (x != this.s) {
            stack.push(x = this.edgeTo[x]);
        }
        return stack;
    }
}
