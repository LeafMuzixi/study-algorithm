package com.mzx.algorithm.graph;

/**
 * 有向权重边
 */
public class DirectedEdge {
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

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * 获取起点
     *
     * @return 起点
     */
    public int from() {
        return v;
    }

    /**
     * 获取终点
     *
     * @return 终点
     */
    public int to() {
        return w;
    }
}
