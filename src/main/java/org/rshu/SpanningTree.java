package org.rshu;

import java.util.ArrayList;
import java.util.Comparator;

public class SpanningTree {
    public SpanningTree(final Graph graph) {
        //ctor
        this.edges = graph.getEdges();
        this.vertices = new ArrayList<Vertex>();
        this.minimalSpanningTree = new ArrayList<Edge>();
        this.makeMinimalSpanningTree();
    }

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

    private void splitEdgeToVertices(final Edge edge) {
        Vertex first = edge.getFirstVertex();
        Vertex second = edge.getSecondVertex();

        if(!this.vertices.contains(first)) {
            this.vertices.add(first);
        }

        if(!this.vertices.contains(second)) {
            this.vertices.add(second);
        }
    }

    private void sortEdges() {
        this.edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(final Edge e1, final Edge e2) {
                return Integer.compare(e1.getWeight(), e2.getWeight());
            }
        });
    }

    private ArrayList<Edge> edges;

    private ArrayList<Edge> minimalSpanningTree;

    private ArrayList<Vertex> vertices;
}
