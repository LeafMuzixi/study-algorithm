package com.mzx.algorithm.graph;

import com.mzx.algorithm.uf.UFTreeWeighted;

import java.util.*;
import java.util.stream.Collectors;

public class KruskalMST {
    /**
     * 存储最小生成树所有边
     */
    private Queue<Edge> queue;
    /**
     * 并查集
     */
    private UFTreeWeighted uf;
    /**
     * 存储所有边
     */
    private Queue<Edge> edges;

    public KruskalMST(EdgeWeightedGraph graph) {
        this.queue = new ArrayDeque<>();
        this.uf = new UFTreeWeighted(graph.V());
        this.edges = new PriorityQueue<>(graph.edges());
        while (!this.edges.isEmpty() && this.queue.size() < graph.V() - 1) {
            // 找到权重最小的边
            Edge edge = this.edges.poll();
            // 找到该边的两个顶点
            int v = edge.either();
            int w = edge.other(v);
            // 判断这两顶点是否在同一树中，
            if (this.uf.connected(v, w)) {
                continue;
            }
            this.uf.union(v, w);
            this.queue.offer(edge);
        }
    }

    /**
     * 获取最小生成树所有边
     *
     * @return 边队列
     */
    public Queue<Edge> edges() {
        return this.queue;
    }
}
