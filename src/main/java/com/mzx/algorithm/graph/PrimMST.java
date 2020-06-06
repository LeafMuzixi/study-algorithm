package com.mzx.algorithm.graph;

import com.mzx.algorithm.priority.IndexMinPriorityQueue;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 普里姆算法
 * 搜索最小生成树
 */
public class PrimMST {
    /**
     * 存储顶点到最小生成数的最短边
     */
    private Edge[] edgeTo;
    /**
     * 存储顶点到最小生成树之间最短边的权重
     */
    private double[] distTo;
    /**
     * 标识顶点是否在树中
     */
    private boolean[] marked;
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

    public PrimMST(EdgeWeightedGraph graph) {
        this.edgeTo = new Edge[graph.V()];
        this.distTo = new double[graph.V()];
        Arrays.fill(this.distTo, Double.MAX_VALUE);
        this.marked = new boolean[graph.V()];
        this.queue = new PriorityQueue<>(graph.V());
        // 让顶点 0 进入到树中
        this.distTo[0] = 0;
        this.queue.offer(new PointWeight(0, 0));
        // 遍历索引最小优先队列
        while (!queue.isEmpty()) {
            visit(graph, queue.poll().point);
        }

    }

    /**
     * 将顶点 v 添加到最小生成树中，并更新数据
     *
     * @param graph 权重图
     * @param v     顶点
     */
    private void visit(EdgeWeightedGraph graph, int v) {
        // 把顶点添加到树中
        this.marked[v] = true;
        // 更新数据
        for (Edge edge : graph.adj(v)) {
            // 获取另一个顶点
            int other = edge.other(v);
            // 如果另一顶点已经在树中，跳过
            if (this.marked[other]) {
                continue;
            }
            if (edge.getWeight() < distTo[other]) {
                this.edgeTo[other] = edge;
                this.distTo[other] = edge.getWeight();
                // 如果队列中存在到这个顶点要检查的边
                Optional<PointWeight> optional = queue.stream().filter(pointWeight -> pointWeight.point == other).findFirst();
                if (optional.isPresent()) {
                    PointWeight pointWeight = optional.get();
                    queue.remove(pointWeight);
                    pointWeight.weight = edge.getWeight();
                    queue.offer(pointWeight);
                } else {
                    queue.offer(new PointWeight(other, edge.getWeight()));
                }
            }
        }
    }

    /**
     * 获取最小生成树所有边
     *
     * @return 边队列
     */
    public Queue<Edge> edges() {
        return Arrays.stream(this.edgeTo).filter(Objects::nonNull).collect(Collectors.toCollection(ArrayDeque::new));
    }
}
