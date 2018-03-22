package greedy.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private final DirectedGraph g;
    private final boolean visited[];
    private List<Integer> list = new ArrayList<>();

    public BFS(DirectedGraph g) {
        this.g = g;
        this.visited = new boolean[this.g.getNumVertices()];
    }

    public void breathFirstSearch(int v) {
        Queue<Integer> q = new LinkedList<>();
        this.visited[v] = true;
        q.add(v);
        while (!q.isEmpty()) {
            v = q.poll();
            this.list.add(v);
            for (int j : this.g.getAdjacents(v)) {
                if (!this.visited[j]) {
                    this.visited[j] = true;
                    q.add(j);
                }
            }
        }
    }

    public void printBFStraversal() {
        // Print contents of list
        System.out.println("");
        for (int i = 0; i < this.list.size(); i++) {
            System.out.print(this.list.get(i) + " ");
        }
    }

    public List<Integer> getBFStraversal() {
        return this.list;
    }
}
