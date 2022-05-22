package org.rshu;

public class Edge {
    public Edge(final String vertices, final int weight) {
        //ctor
        this.firstVertex = new Vertex(vertices.charAt(0));
        this.secondVertex = new Vertex(vertices.charAt(1));
        this.edgeWeight = weight;
    }

    public Edge(final Vertex firstVertex, final Vertex secondVertex, final int weight) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.edgeWeight = weight;
    }

    public Edge(final char firstVertexName, final char secondVertexName, final int weight) {
        this.firstVertex = new Vertex(firstVertexName);
        this.secondVertex = new Vertex(secondVertexName);
        this.edgeWeight = weight;
    }

    //weigth getters and setters
    public int getWeight() {
        return this.edgeWeight;
    }
    public void setWeight(final int weight) {
        this.edgeWeight = weight;
    }

    //first vertex getters and setters
    public Vertex getFirstVertex() {
        return this.firstVertex;
    }

    public void setFirstVertex(final Vertex vertex) {
        this.firstVertex = vertex;
    }

    //second vertex getters and setters
    public Vertex getSecondVertex() {
        return this.secondVertex;
    }

    public void setSecondVertex(final Vertex vertex) {
        this.secondVertex = vertex;
    }

    private int edgeWeight;
    private Vertex firstVertex;
    private Vertex secondVertex;
}
