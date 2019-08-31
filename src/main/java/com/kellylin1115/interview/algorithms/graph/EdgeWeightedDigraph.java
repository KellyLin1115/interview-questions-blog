package com.kellylin1115.interview.algorithms.graph;

import java.util.ArrayList;

public class EdgeWeightedDigraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    // number of vertices in this digraph
    private final int V;
    // number of edges in this digraph
    private int E;
    // adj[v] = adjacency list for vertex v
    private ArrayList<DirectedEdge>[] adj;
    //indegree[v] = indegree of vertex v
    private int[] indegree;

    public EdgeWeightedDigraph(int V){
        if(V < 0) new IllegalArgumentException("Number of vertices in a digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (ArrayList<DirectedEdge>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<DirectedEdge>();
        }
    }

    public void addEdge(DirectedEdge e){
        int v = e.from();
        int w = e.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        indegree[w] = v;
        E++;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public int outdegree(int v){
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v){
        validateVertex(v);
        return indegree[v];
    }

    public ArrayList<DirectedEdge> adj(int v){
        validateVertex(v);
        return adj[v];
    }

    public ArrayList<DirectedEdge> edges(){
        ArrayList<DirectedEdge> edges = new ArrayList<>();
        for (int v = 0; v < V; v++) {
           for (DirectedEdge edge: adj(v)){
               edges.add(edge);
           }
        }
        return edges;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String edges = "4 5 0.35\n" +
                "5 4 0.35\n" +
                "4 7 0.37\n" +
                "5 7 0.28\n" +
                "7 5 0.28\n" +
                "5 1 0.32\n" +
                "0 4 0.38\n" +
                "0 2 0.26\n" +
                "7 3 0.39\n" +
                "1 3 0.29\n" +
                "2 7 0.34\n" +
                "6 2 0.40\n" +
                "3 6 0.52\n" +
                "6 0 0.58\n" +
                "6 4 0.93";
        String[] edgesArray = edges.split("\n") ;

        EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(8);
        for (String edge : edgesArray) {
            String[] items = edge.split(" ");
            ewd.addEdge(new DirectedEdge(Integer.parseInt(items[0]), Integer.parseInt(items[1]), Double.parseDouble(items[2])));
        }
        System.out.println(ewd);
    }
}
