package org.rshu.graph;

public class Edge {
    private int edgeWeight;
    private Vertex firstVertex;
    private Vertex secondVertex;

    public Edge(String vertices){
        String[] split = vertices.split(" ");
        this.firstVertex = new Vertex(split[0].charAt(0));
        this.secondVertex = new Vertex(split[0].charAt(1));
        this.edgeWeight = Integer.parseInt(split[1]);
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
}
