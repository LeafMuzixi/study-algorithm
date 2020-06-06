package com.mzx.algorithm.graph;

import org.jetbrains.annotations.NotNull;

/**
 * 权重边
 */
public class Edge implements Comparable<Edge> {
    /**
     * 起点
     */
    private final int v;
    /**
     * 终点
     */
    private final int w;
    /**
     * 权重
     */
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * 获取边上的一个顶点
     *
     * @return 顶点
     */
    public int either() {
        return v;
    }

    /**
     * 获取边上的另一个顶点
     *
     * @param vertex 顶点
     * @return 另一个顶点
     */
    public int other(int vertex) {
        return vertex == v ? w : v;
    }


    @Override
    public int compareTo(@NotNull Edge edge) {
        if (weight > edge.weight) {
            return 1;
        } else if (weight < edge.weight) {
            return -1;
        }
        return 0;
    }
}
