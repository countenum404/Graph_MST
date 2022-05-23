package org.rshu.graph;

public class Edge {
    /**
     * @param vertices gets a vertices as instance of String type and should be 2 chars in length f.e. AB
     * @param weight Weigth of the edge
     */
    public Edge(final String vertices, final int weight) {
        //ctor
        this.firstVertex = new Vertex(vertices.charAt(0));
        this.secondVertex = new Vertex(vertices.charAt(1));
        this.edgeWeight = weight;
    }

    /**
     * @param firstVertex First Vertex (instance of Vertex)
     * @param secondVertex Second Vertex (instance of Vertex)
     * @param weight Weigth of the edge
     */
    public Edge(final Vertex firstVertex, final Vertex secondVertex, final int weight) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.edgeWeight = weight;
    }

    /**
     * @param firstVertexName Name of the first Vertex (instance of char)
     * @param secondVertexName Name of the second Vertex (instance of char)
     * @param weight Weigth of the edge
     */
    public Edge(final char firstVertexName, final char secondVertexName, final int weight) {
        this.firstVertex = new Vertex(firstVertexName);
        this.secondVertex = new Vertex(secondVertexName);
        this.edgeWeight = weight;
    }


    /**
     * @return Returns and weight of the edge
     */
    public int getWeight() {
        return this.edgeWeight;
    }

    /**
     * @param weight takes and set the weight of the edge
     */
    public void setWeight(final int weight) {
        this.edgeWeight = weight;
    }


    /**
     * @return returns the first vertex of the edge
     */
    public Vertex getFirstVertex() {
        return this.firstVertex;
    }

    /**
     * @param vertex takes and sets the first vertex of the edge
     */
    public void setFirstVertex(final Vertex vertex) {
        this.firstVertex = vertex;
    }

    /**
     * @return returns the second vertex of the edge
     */
    public Vertex getSecondVertex() {
        return this.secondVertex;
    }

    /**
     * @param vertex takes and sets the second vertex of the edge
     */
    public void setSecondVertex(final Vertex vertex) {
        this.secondVertex = vertex;
    }

    private int edgeWeight;
    private Vertex firstVertex;
    private Vertex secondVertex;
}
