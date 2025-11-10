import java.util.List;
public interface Graph {

    /***
     * Add a new Edge between the vertex v and w
     */
    public void addEdge(int v, int w);

    /**
     * Return the amount of Vertex in the Graph
     */
    public int V();

    /**
     * Return the amount of Edges in the Graph
     */
    public int E();

    /**
     * Return the adjacency list of a Node v
     */
    public List<Integer> adj(int v);
}