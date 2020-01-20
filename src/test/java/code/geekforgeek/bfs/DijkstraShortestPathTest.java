package code.geekforgeek.bfs;

import code.adt.graph.SimpleDirectedGraph;
import code.adt.graph.SimpleWeightedEdge;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DijkstraShortestPathTest {

    @Test
    public void find() {
        SimpleDirectedGraph<SimpleWeightedEdge> graph = new SimpleDirectedGraph<>(5);
        graph.addEdge(new SimpleWeightedEdge(0, 1, 10));
        graph.addEdge(new SimpleWeightedEdge(0, 4, 5));
        graph.addEdge(new SimpleWeightedEdge(1, 2, 1));
        graph.addEdge(new SimpleWeightedEdge(1, 4, 2));
        graph.addEdge(new SimpleWeightedEdge(2, 3, 4));
        graph.addEdge(new SimpleWeightedEdge(3, 2, 6));
        graph.addEdge(new SimpleWeightedEdge(3, 0, 7));
        graph.addEdge(new SimpleWeightedEdge(4, 1, 3));
        graph.addEdge(new SimpleWeightedEdge(4, 2, 9));
        graph.addEdge(new SimpleWeightedEdge(4, 3, 2));

        assertArrayEquals(new double[]{0.0, 8.0, 9.0, 7.0, 5.0}, new DijkstraShortestPath().find(graph, 0), 0);
    }
}