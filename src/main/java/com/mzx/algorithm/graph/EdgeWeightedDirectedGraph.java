package com.mzx.algorithm.graph;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 加权有向图
 */
public class EdgeWeightedDirectedGraph {
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
    private Queue<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDirectedGraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[v];
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
     * 添加边
     *
     * @param edge 边
     */
    public void addEdge(DirectedEdge edge) {
        this.adj[edge.from()].offer(edge);
        this.E++;
    }

    /**
     * 获取顶点相邻的所有顶点
     *
     * @param v 顶点
     * @return 顶点队列
     */
    public Queue<DirectedEdge> adj(int v) {
        return this.adj[v];
    }

    /**
     * 获取所有边
     *
     * @return 边队列
     */
    public Queue<DirectedEdge> edges() {
        return Arrays.stream(this.adj).flatMap(Collection::stream).collect(Collectors.toCollection(ArrayDeque::new));
    }
}
