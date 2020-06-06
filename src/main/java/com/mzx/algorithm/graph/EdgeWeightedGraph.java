package com.mzx.algorithm.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 加权无向图
 */
public class EdgeWeightedGraph {
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
    private Queue<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[v];
        for (int i = 0; i < v; i++) {
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
     * 添加边
     *
     * @param edge 边
     */
    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        this.adj[v].offer(edge);
        this.adj[w].offer(edge);
        this.E++;
    }

    /**
     * 获取顶点相邻的所有顶点
     *
     * @param v 顶点
     * @return 顶点队列
     */
    public Queue<Edge> adj(int v) {
        return this.adj[v];
    }

    /**
     * 获取所有边
     *
     * @return 边队列
     */
    public Queue<Edge> edges() {
        Queue<Edge> edges = new ArrayDeque<>();
        for (int i = 0; i < this.adj.length; i++) {
            for (Edge edge : this.adj[i]) {
                if (edge.other(i) < i) {
                    edges.offer(edge);
                }
            }
        }
        return new ArrayDeque<>(edges);
    }
}
