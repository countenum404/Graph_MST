package org.rshu.graph;

import java.util.ArrayList;
import java.util.Comparator;

public class SpanningTree {
    /**
     *  Takes all edges from graph, used as container in Kruskal algorithm
     */
    private ArrayList<Edge> edges;

    /**
     *  Container of the edges that processed by Kruskal's algorithm
     */
    private ArrayList<Edge> minimalSpanningTree;

    /**
     *  Container that takes vertices from edges and by Kruskal's algorithm
     */
    private ArrayList<Vertex> vertices;
    /**
     * @param graph takes a Graph object argument and creates a Minimal Spanning Tree
     */
    public SpanningTree(Graph graph) {
        //ctor
        this.edges = graph.getEdges();
        this.vertices = new ArrayList<Vertex>();
        this.minimalSpanningTree = new ArrayList<Edge>();
        this.makeMinimalSpanningTree();
    }

    public void printSpanningTree()
    {
        System.out.println(this.getMinimalSpanningTreeString());
    }

    /**
     * @return Returns a view of Spanning Tree as String, so you can print these or use in other cases
     */
    public String getMinimalSpanningTreeString() {
        //Generate output string
        String result = "";
        String edge;
        String weight;
        for (int i = 0; i < this.minimalSpanningTree.size(); i++) {
            Edge e = this.minimalSpanningTree.get(i);
            edge = String.valueOf(e.getFirstVertex().getVertexName()) + String.valueOf(e.getSecondVertex().getVertexName());
            weight = String.valueOf(e.getWeight());
            result += edge + " " + weight + "\n";
        }
        return result;
    }

    /**
     * Kruskal algorithm function that provides after processing the minimalSpanningTree as the class member
     */
    private void makeMinimalSpanningTree() {

        //Kruskal algorithm

        //sort edges
        this.sortEdges();

        //define a vertices
        edges.forEach(edge -> this.splitEdgeToVertices(edge));
        //make a minimal spanning tree
        int rank = 1;
        Vertex first;
        Vertex second;
        for (Edge edge : edges) {
            first = vertices.get(vertices.indexOf(edge.getFirstVertex()));
            second = vertices.get(vertices.indexOf(edge.getSecondVertex()));
            if (first.getRank() == 0 && second.getRank() == 0) {
                first.setRank(rank);
                second.setRank(rank);
                minimalSpanningTree.add(edge);
                rank++;
            } else if (first.getRank() == 0 && second.getRank() > 0) {
                first.setRank(second.getRank());
                minimalSpanningTree.add(edge);
            } else if (second.getRank() == 0 && first.getRank() > 0) {
                second.setRank(first.getRank());
                minimalSpanningTree.add(edge);
            } else if (first.getRank() != second.getRank()) {
                int minRank = Math.min(first.getRank(), second.getRank());
                int maxRank = Math.max(first.getRank(), second.getRank());
                minimalSpanningTree.add(edge);
                for (Vertex v : this.vertices) {
                    if (v.getRank() == minRank) {
                        v.setRank(maxRank);
                    }
                }
            }
        }
    }


    /**
     * @param edge gets an edge to split into the unique Vertices
     */
    private void splitEdgeToVertices(Edge edge) {
        Vertex first = edge.getFirstVertex();
        Vertex second = edge.getSecondVertex();

        if (!this.vertices.contains(first)) {
            this.vertices.add(first);
        }

        if (!this.vertices.contains(second)) {
            this.vertices.add(second);
        }
    }

    /**
     *  Just sorting the edges
     */
    private void sortEdges() {
        this.edges.sort((e1, e2) -> Integer.compare(e1.getWeight(), e2.getWeight()));
    }
}
