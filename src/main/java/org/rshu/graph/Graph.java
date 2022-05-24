package org.rshu.graph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Edge> edges;
    /**
     * Basic consrtuctor
     */
    public Graph() {
        edges = new ArrayList<Edge>();
    }

    /**
     * @return the edges
     */
    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    /**
     * @param edge is need to add Edge
     */
    public void addEdge(Edge edge) {
        edges.add(edge);
    }


}
