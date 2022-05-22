package org.rshu;

public class Vertex {
    public Vertex(final char Name) {
        this.vertexName = Name;
    }

    public void setVertexName(final char Name) {
        this.vertexName = Name;
        this.rank = 0;
    }

    public char getVertexName() {
        return  this.vertexName;
    }

    public void setRank(final int value) {
        this.rank = value;
    }

    public int getRank() {
        return this.rank;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Vertex) {
            Vertex v = (Vertex) obj;
            if (v.vertexName == this.vertexName) {
                return true;
            }
        }
        return false;
    }

    private char vertexName;
    private int rank;

}
