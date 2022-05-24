package org.rshu.graph;

public class Vertex {
    private char vertexName;
    private int rank;
    /**
     * @param Name Takes an argument (instance of char)
     *             and sets rank to 0
     */
    public Vertex(char Name) {
        this.vertexName = Name;
        this.rank = 0;
    }

    /**
     * @param Name Takes an argument (instance of char)
     *             and sets rank to 0
     */
    public void setVertexName(char Name) {
        this.vertexName = Name;
        this.rank = 0;
    }

    /**
     * @return name of the Vertex object
     */
    public char getVertexName() {
        return  this.vertexName;
    }

    /**
     * @param value is a rank (used in Kruskal's algorithm as mark of Set)
     */
    public void setRank(int value) {
        this.rank = value;
    }

    /**
     * @return a rank (used in Kruskal's algorithm as mark of Set)
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * @param obj overrided equals method to make Vertex comparable by Name
     * @return returns a true if the obj param is instance of Vertex
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex) {
            Vertex v = (Vertex) obj;
            if (v.vertexName == this.vertexName) {
                return true;
            }
        }
        return false;
    }



}
