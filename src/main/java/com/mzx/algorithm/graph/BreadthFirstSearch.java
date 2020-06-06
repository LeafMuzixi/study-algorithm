package com.mzx.algorithm.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 广度优先搜索
 */
public class BreadthFirstSearch {
    /**
     * 标记顶点是否已被搜索
     */
    private boolean[] marked;
    /**
     * 记录多少顶点与目标节点相通
     */
    private int count;
    /**
     * 存储邻接表待搜索顶点
     */
    private Queue<Integer> waitSearch;

    /**
     * 构造方法
     *
     * @param graph 图
     * @param s     搜索顶点
     */
    public BreadthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.count = 0;
        this.waitSearch = new ArrayDeque<>();
        bfs(graph, s);
    }

    /**
     * 广度优先搜索
     *
     * @param graph 图
     * @param v     当前顶点
     */
    private void bfs(Graph graph, int v) {
        if (this.marked[v]) {
            return;
        }
        this.marked[v] = true;
        this.count++;
        waitSearch.offer(v);
        while (!waitSearch.isEmpty()) {
            Integer w = waitSearch.poll();
            graph.adj(w).forEach(node -> bfs(graph, node));
        }
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
