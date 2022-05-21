package org.rshu;

public class Vertex {
    public Vertex(char Name)
    {
        this.vertexName = Name;
    }

    public void setVertexName(char Name)
    {
        this.vertexName = Name;
        this.rank = 0;
    }

    public char getVertexName()
    {
        return  this.vertexName;
    }

    public void setRank(int value)
    {
        this.rank = value;
    }

    public int getRank()
    {
        return this.rank;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Vertex)
        {
            Vertex v = (Vertex) obj;
            if (v.vertexName == this.vertexName)
            {
                return true;
            }
        }
        return false;
    }

    protected char vertexName;

    protected int rank;

}
