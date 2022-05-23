package org.rshu;

import java.util.ArrayList;
import java.util.Comparator;

public class SpanningTree {
    /**
     * @param graph takes a Graph object argument and creates a Minimal Spanning Tree
     */
    public SpanningTree(final Graph graph) {
        //ctor
        this.edges = graph.getEdges();
        this.vertices = new ArrayList<Vertex>();
        this.minimalSpanningTree = new ArrayList<Edge>();
        this.makeMinimalSpanningTree();
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
        Edge e;
        for (int i = 0; i < edges.size(); i++) {
            e = edges.get(i);
            this.splitEdgeToVertices(e);
        }
        //make a minimal spanning tree
        int rank = 1;
        Vertex first;
        Vertex second;
        for (int i = 0; i < edges.size(); i++) {
            e = edges.get(i);
            first = vertices.get(vertices.indexOf(e.getFirstVertex()));
            second = vertices.get(vertices.indexOf(e.getSecondVertex()));
            if (first.getRank() == 0 && second.getRank() == 0) {
                first.setRank(rank);
                second.setRank(rank);
                minimalSpanningTree.add(e);
                rank++;
            } else if (first.getRank() == 0 && second.getRank() > 0) {
                first.setRank(second.getRank());
                minimalSpanningTree.add(e);
            } else if (second.getRank() == 0 && first.getRank() > 0) {
                second.setRank(first.getRank());
                minimalSpanningTree.add(e);
            } else if (first.getRank() != second.getRank()) {
                int minRank = Math.min(first.getRank(), second.getRank());
                int maxRank = Math.max(first.getRank(), second.getRank());
                minimalSpanningTree.add(e);
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
    private void splitEdgeToVertices(final Edge edge) {
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
        this.edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(final Edge e1, final Edge e2) {
                return Integer.compare(e1.getWeight(), e2.getWeight());
            }
        });
    }

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
}
