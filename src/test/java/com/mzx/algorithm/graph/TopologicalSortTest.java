package com.mzx.algorithm.graph;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TopologicalSortTest {
    private TopologicalSort sort;

    @BeforeAll
    public void init() {
        DirectedGraph graph = new DirectedGraph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(1, 3);

        this.sort = new TopologicalSort(graph);
    }

    @Test
    public void sort() {
        assertFalse(this.sort.isCycle());
        Stack<Integer> order = this.sort.order();
        Collections.reverse(order);
        System.out.println(Joiner.on(",").join(order));
    }
}