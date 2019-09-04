package com.kellylin1115.interview.algorithms.graph;

import com.kellylin1115.interview.algorithms.sortingsearching.IndexMinPQ;

import java.util.Stack;

public class DijkstraSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph graph, int s){
        for (DirectedEdge edge : graph.edges()) {
            if (edge.weight() < 0) throw new IllegalArgumentException("edge " + edge + "has negative weight");
        }

        int V = graph.V();
        edgeTo = new DirectedEdge[V];
        distTo = new double[V];

        validateVertex(s);

        for (int v = 0; v < V; v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq = new IndexMinPQ<>(V);
        pq.insert(s, distTo[s]);
        while(!pq.isEmpty()){
            int v = pq.delMin();
            for (DirectedEdge edge : graph.adj(v)){
                relax(edge);
            }
        }
    }

    private void relax(DirectedEdge edge){
        int v = edge.from();
        int w = edge.to();
        if(distTo[w] > distTo[v] + edge.weight()){
            distTo[w] = distTo[v] + edge.weight();
            edgeTo[w] = edge;
            if(pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }

    public double distTo(int v){
        validateVertex(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v){
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<DirectedEdge> paths = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null ; e = edgeTo[e.from()]) {
            paths.push(e);
        }
        return paths;
    }

    private void validateVertex(int v){
        int V = distTo.length;
        if(v < 0 || v >= V) throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
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

        DijkstraSP dsp = new DijkstraSP(ewd, 0);
        for (int v = 0; v < ewd.V(); v++) {
            if(dsp.hasPathTo(v)){
                System.out.printf("%d to %d (%.2f)", 0, v, dsp.distTo[v]);
                for (DirectedEdge e : dsp.pathTo(v)) {
                    System.out.print(e + "   ");
                }
                System.out.println();
            }else{
                System.out.printf("%d to %d has no path", 0, v);
            }
        }

    }
}
