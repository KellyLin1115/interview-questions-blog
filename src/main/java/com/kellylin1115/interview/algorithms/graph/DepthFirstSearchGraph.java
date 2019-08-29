package com.kellylin1115.interview.algorithms.graph;

import java.util.LinkedList;

public class DepthFirstSearchGraph {
    private int V;
    private LinkedList<Integer>[] adj;

    public DepthFirstSearchGraph(int v){
        this.V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V ; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    //the vertices reachable from a given source vertex.
    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        dfs(visited, s);
    }

    //All the vertices may not be reachable from a given vertex (example Disconnected graph).
    public void dfs(){
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(visited[i] == false)
                dfs(visited, i);
        }
    }

    private void dfs(boolean[] visited, int s){
        visited[s] = true;
        System.out.println(" " + s + " ");
        for (Integer item : adj[s]) {
            if (!visited[item]) {
                visited[item] = true;
                dfs(visited, item);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearchGraph g = new DepthFirstSearchGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
        g.dfs(2);

        System.out.println("Following is Depth First Traversal (all the vertices");
        g.dfs();
    }
}