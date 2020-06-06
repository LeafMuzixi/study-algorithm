package com.mzx.algorithm.graph;

/**
 * 有向环检测
 */
public class DirectedCycle {
    /**
     * 存储搜索状态
     */
    private boolean[] marked;
    /**
     * 标记图是否有环
     */
    private boolean hasCycle;
    /**
     * 顶点栈
     */
    private boolean[] onStack;

    /**
     * 构造方法
     *
     * @param graph 有向图
     */
    public DirectedCycle(DirectedGraph graph) {
        this.marked = new boolean[graph.V()];
        this.hasCycle = false;
        this.onStack = new boolean[graph.V()];
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
        this.onStack[v] = true;
        for (Integer w : graph.adj(v)) {
            dfs(graph, w);
            if (this.onStack[w]) {
                this.hasCycle = true;
                return;
            }
        }
        this.onStack[v] = false;
    }

    /**
     * 判断当前图中是否有环
     *
     * @return true / false;
     */
    public boolean hasCycle() {
        return this.hasCycle;
    }
}
