package com.kellylin1115.interview.algorithms.graph;

public class DirectedEdge{
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight){
        if(w < 0) throw new IllegalArgumentException("Vertex names must be non-negative integers");
        if(v < 0) throw new IllegalArgumentException("Vertex names must be non-negative integers");
        if(Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public double weight(){
        return weight;
    }

    public String toString(){
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }

    public static void main(String[] args) {
        DirectedEdge de = new DirectedEdge(2, 4, 9.34);
        System.out.println(de);
    }
}
