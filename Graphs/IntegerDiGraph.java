/**
 * IntegerDiGraph is a directed graph implementation that uses an adjacency list
 * representation to store the graph structure.
 * 
 * This class represents a directed graph with a fixed number of vertices,
 * where vertices are identified by integers from 0 to V-1. Edges are directed,
 * meaning an edge from vertex v to vertex w does not imply an edge from w to v.
 * 
 * The graph is implemented using an array of LinkedLists, where each index
 * represents a vertex and contains a list of all vertices it points to (outgoing edges).
 * 
 * @author cgalean0
 * @version 1.0
 */
/**
 * 
 */
import java.util.List;
import java.util.LinkedList;

public class IntegerDiGraph implements Graph{
    private final int V; // Vertex of the Graph
    private int E; // Edges of the graph
    private List<Integer>[] adj;
    
    @SuppressWarnings("unchecked")
    public IntegerDiGraph(int V) {
        if (V < 0)
            throw new IllegalArgumentException("Amount of vertex cannot be negative amount");
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for (int v = 0; v <= V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(int v, int w) {
        if (v < 0 || v > V)
            throw new IllegalArgumentException("The vertex: v must be between 0 and " + (V - 1));
        if (w < 0 || w > V)
            throw new IllegalArgumentException("The vertex: w must be between 0 and " + (V - 1));

        E++; // Increment the amount of Edges
        adj[v].add(w);
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
        return adj[v];
    }


}