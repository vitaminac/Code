package code.geekforgeek.greedy;

import code.adt.graph.SimpleUndirectedGraph;
import code.adt.graph.SimpleWeightedEdge;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class PrimMinimumSpanningTreeTest {

    @Test
    public void find() {
        SimpleUndirectedGraph<SimpleWeightedEdge> graph = new SimpleUndirectedGraph<SimpleWeightedEdge>(7);
        HashSet<SimpleWeightedEdge> sol = new HashSet<>();
        graph.addEdge(new SimpleWeightedEdge(0, 2, 1));
        graph.addEdge(new SimpleWeightedEdge(0, 3, 2));
        graph.addEdge(new SimpleWeightedEdge(6, 2, 5));
        graph.addEdge(new SimpleWeightedEdge(3, 4, 1));
        graph.addEdge(new SimpleWeightedEdge(4, 1, 2));
        graph.addEdge(new SimpleWeightedEdge(1, 5, 4));
        graph.addEdge(new SimpleWeightedEdge(2, 3, 3));
        graph.addEdge(new SimpleWeightedEdge(0, 6, 6));
        graph.addEdge(new SimpleWeightedEdge(6, 4, 8));
        graph.addEdge(new SimpleWeightedEdge(6, 1, 7));
        graph.addEdge(new SimpleWeightedEdge(3, 5, 9));

        SimpleWeightedEdge edge1_3 = new SimpleWeightedEdge(0, 2, 1);
        SimpleWeightedEdge edge1_4 = new SimpleWeightedEdge(0, 3, 2);
        SimpleWeightedEdge edge7_3 = new SimpleWeightedEdge(6, 2, 5);
        SimpleWeightedEdge edge4_5 = new SimpleWeightedEdge(3, 4, 1);
        SimpleWeightedEdge edge5_2 = new SimpleWeightedEdge(4, 1, 2);
        SimpleWeightedEdge edge2_6 = new SimpleWeightedEdge(1, 5, 4);
        sol.add(edge1_3);
        sol.add(edge7_3);
        sol.add(edge1_4);
        sol.add(edge4_5);
        sol.add(edge5_2);
        sol.add(edge2_6);

        assertEquals(sol, new PrimMinimumSpanningTree().find(graph));
    }
}