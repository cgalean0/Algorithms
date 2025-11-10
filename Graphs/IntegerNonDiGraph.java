/**
 * A non-directed graph implementation using an adjacency list representation.
 * This class represents an undirected graph with integer vertices numbered from 0 to V-1.
 * 
 * The graph is implemented using an array of linked lists, where each index represents
 * a vertex and the linked list at that index contains all adjacent vertices.
 * 
 * In a non-directed graph, edges are bidirectional. When an edge is added between
 * vertices v and w, both vertices are added to each other's adjacency lists.
 * 
 * @author cgalean0
 * @version 1.0
 */
import java.util.List;
import java.util.LinkedList;

public class IntegerNonDiGraph implements Graph {
    private final int V; // amount of vertex in the Graph
    private int E; // amount of Edges in the graph
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public IntegerNonDiGraph(int V) {
        if (V < 0)
            throw new IllegalArgumentException("Amount of vertex cannot be negative amount");

        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for(int v = 0; v <= V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(int v, int w) {
        if (v < 0 || v > V)
            throw new IllegalArgumentException("The vertex: v must be between 0 and " + (V - 1));
        if (w < 0 || w > V)
            throw new IllegalArgumentException("The vertex: w must be between 0 and " + (V - 1));

        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public List<Integer> adj(int v) {
       return adj(v);
    }

    
}