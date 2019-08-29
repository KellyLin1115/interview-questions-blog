package com.kellylin1115.interview.algorithms.graph;

import java.util.LinkedList;

public class BreadthFirstSearchGraph{
    private int V;
    private LinkedList<Integer>[] adj;

    public BreadthFirstSearchGraph(int v){
        this.V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V ; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while(queue.size() != 0){
            int r = queue.poll();
            System.out.println(" " + r + " ");
            for (Integer item : adj[r]) {
                if (!visited[item]){
                    visited[item] = true;
                    queue.add(item);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearchGraph g = new BreadthFirstSearchGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(2);
    }
}
