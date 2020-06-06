package com.mzx.algorithm.graph;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.*;

import java.util.Collections;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepthFirstPathsTest {
    private DepthFirstPaths paths;

    @BeforeAll
    public void init() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 5);

        this.paths = new DepthFirstPaths(graph, 0);
    }

    @Test
    public void test() {
        Stack<Integer> parts = this.paths.pathTo(4);
        Collections.reverse(parts);
        System.out.println(Joiner.on("-").join(parts));
    }
}