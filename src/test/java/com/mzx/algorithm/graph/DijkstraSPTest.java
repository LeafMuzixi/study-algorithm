package com.mzx.algorithm.graph;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DijkstraSPTest {
    private DijkstraSP dijkstraSP;

    @BeforeAll
    public void init() {
        EdgeWeightedDirectedGraph graph = new EdgeWeightedDirectedGraph(8);

        graph.addEdge(new DirectedEdge(4, 5, 0.35));
        graph.addEdge(new DirectedEdge(5, 4, 0.35));
        graph.addEdge(new DirectedEdge(4, 7, 0.37));
        graph.addEdge(new DirectedEdge(5, 7, 0.28));
        graph.addEdge(new DirectedEdge(7, 5, 0.28));

        graph.addEdge(new DirectedEdge(5, 1, 0.32));
        graph.addEdge(new DirectedEdge(0, 4, 0.38));
        graph.addEdge(new DirectedEdge(0, 2, 0.26));
        graph.addEdge(new DirectedEdge(7, 3, 0.39));
        graph.addEdge(new DirectedEdge(1, 3, 0.29));

        graph.addEdge(new DirectedEdge(2, 7, 0.34));
        graph.addEdge(new DirectedEdge(6, 2, 0.40));
        graph.addEdge(new DirectedEdge(3, 6, 0.52));
        graph.addEdge(new DirectedEdge(6, 0, 0.58));
        graph.addEdge(new DirectedEdge(6, 4, 0.93));

        this.dijkstraSP = new DijkstraSP(graph, 0);
    }

    @Test
    public void test() {
        this.dijkstraSP.pathTo(6).forEach(edge -> {
            int v = edge.from();
            int w = edge.to();
            System.out.println(v + " - " + w + " :: " + edge.getWeight());
        });
    }
}