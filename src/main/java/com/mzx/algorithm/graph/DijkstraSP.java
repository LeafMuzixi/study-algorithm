package com.mzx.algorithm.graph;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * 最短路径 戴克斯特拉算法
 */
public class DijkstraSP {
    /**
     * 存储到当前顶点最后一条边
     */
    private DirectedEdge[] edgeTo;
    /**
     * 存储到当前顶点最短路径的总权重
     */
    private double[] distTo;
    /**
     * 存储树中顶点与非树中顶点之间的有效横切边
     */
    private Queue<PointWeight> queue;

    /**
     * 顶点权重对象
     */
    private class PointWeight implements Comparable<PointWeight> {
        final int point;
        double weight;

        public PointWeight(int point, double weight) {
            this.point = point;
            this.weight = weight;
        }

        @Override
        public int compareTo(@NotNull PointWeight o) {
            if (weight > o.weight) {
                return 1;
            } else if (weight < o.weight) {
                return -1;
            }
            return 0;
        }
    }

    public DijkstraSP(EdgeWeightedDirectedGraph graph, int s) {
        this.edgeTo = new DirectedEdge[graph.V()];
        this.distTo = new double[graph.V()];
        Arrays.fill(this.distTo, Double.POSITIVE_INFINITY);
        this.queue = new PriorityQueue<>();

        this.distTo[s] = 0;
        this.queue.offer(new PointWeight(s, 0));

        while (!this.queue.isEmpty()) {
            relax(graph, this.queue.poll().point);
        }
    }

    /**
     * 松弛图中的顶点
     *
     * @param graph 图
     * @param v     顶点
     */
    private void relax(EdgeWeightedDirectedGraph graph, int v) {
        Queue<DirectedEdge> adj = graph.adj(v);
        for (DirectedEdge edge : adj) {
            int w = edge.to();

            if (this.distTo[v] + edge.getWeight() < this.distTo[w]) {
                this.distTo[w] = this.distTo[v] + edge.getWeight();
                this.edgeTo[w] = edge;

                // 判断树中是否已经存在 w
                // 如果队列中存在到这个顶点要检查的边
                Optional<PointWeight> optional = queue.stream().filter(pointWeight -> pointWeight.point == w).findFirst();
                if (optional.isPresent()) {
                    PointWeight pointWeight = optional.get();
                    queue.remove(pointWeight);
                    pointWeight.weight = this.distTo[w];
                    queue.offer(pointWeight);
                } else {
                    queue.offer(new PointWeight(w, this.distTo[w]));
                }
            }
        }
    }

    /**
     * 获取起点到顶点的最短路径权重
     *
     * @param v 顶点
     * @return 最短路径权重
     */
    public double distTo(int v) {
        return this.distTo[v];
    }

    /**
     * 获取起点到顶点是否可达
     *
     * @param v 顶点
     * @return true / false;
     */
    public boolean hasPathTo(int v) {
        return this.distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * 获取起点到顶点的最短路径
     *
     * @param v 顶点
     * @return 路径栈
     */
    public Stack<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> stack = new Stack<>();
        while (true) {
            DirectedEdge edge = this.edgeTo[v];
            if (edge == null) {
                break;
            }
            stack.push(edge);
            v = edge.from();
        }
        return stack;
    }
}