package org.rshu;

import java.util.ArrayList;

public class Graph {
    public Graph() {
        edges = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void addEdge(final Edge edge) {
        edges.add(edge);
    }

    private ArrayList<Edge> edges;
}
