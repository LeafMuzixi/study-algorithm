package com.mzx.algorithm.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 图
 */
public class Graph {
    /**
     * 顶点数量
     */
    private final int V;
    /**
     * 边数量
     */
    private int E;
    /**
     * 邻接表
     */
    private Queue<Integer>[] adj;

    /**
     * 构造方法
     *
     * @param v 初始化顶点数量
     */
    @SuppressWarnings("unchecked")
    public Graph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[this.V];
        for (int i = 0; i < this.adj.length; i++) {
            this.adj[i] = new ArrayDeque<>();
        }
    }

    /**
     * 获取顶点数量
     *
     * @return 顶点数量
     */
    public int V() {
        return this.V;
    }

    /**
     * 获取边数量
     *
     * @return 边数量
     */
    public int E() {
        return this.E;
    }

    /**
     * 添加边 v-w
     *
     * @param v 顶点
     * @param w 顶点
     */
    public void addEdge(int v, int w) {
        this.adj[v].offer(w);
        this.adj[w].offer(v);
        this.E++;
    }

    /**
     * 获取顶点相邻的所有顶点
     *
     * @param v 顶点
     * @return 顶点队列
     */
    public Queue<Integer> adj(int v) {
        return this.adj[v];
    }
}
