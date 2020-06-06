package com.mzx.algorithm.graph;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepthFirstSearchTest {
    private DepthFirstSearch search;

    @BeforeAll
    public void init() {
        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        this.search = new DepthFirstSearch(graph, 0);
    }

    @Test
    public void test() {
        assertEquals(this.search.count(), 6);
        assertTrue(this.search.marked(5));
        assertFalse(this.search.marked(7));
    }
}