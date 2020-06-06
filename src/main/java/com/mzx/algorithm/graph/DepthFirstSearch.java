package com.mzx.algorithm.graph;

/**
 * 深度优先搜索
 */
public class DepthFirstSearch {
    /**
     * 标记顶点是否已被搜索
     */
    private boolean[] marked;
    /**
     * 记录多少顶点与目标节点相通
     */
    private int count;

    /**
     * 构造方法
     *
     * @param graph 图
     * @param s     搜索顶点
     */
    public DepthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.count = 0;
        dfs(graph, s);
    }

    /**
     * 深度优先搜索
     *
     * @param graph 图
     * @param v     当前顶点
     */
    private void dfs(Graph graph, int v) {
        if (this.marked[v]) {
            return;
        }
        this.marked[v] = true;
        this.count++;
        graph.adj(v).forEach(w -> dfs(graph, w));
    }

    /**
     * 判断 w 顶点是否与目标节点相通
     *
     * @param w 顶点
     * @return true / false;
     */
    public boolean marked(int w) {
        return this.marked[w];
    }

    /**
     * 获取相通顶点数量
     *
     * @return 相通顶点数量
     */
    public int count() {
        return this.count - 1;
    }
}
