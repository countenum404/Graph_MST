package org.rshu;

public class Edge {
    public Edge(String vertices, int weight)
    {
        //ctor
        this.firstVertex = new Vertex(vertices.charAt(0));
        this.secondVertex = new Vertex(vertices.charAt(1));
        this.weight = weight;
    }

    public Edge(Vertex firstVertex, Vertex secondVertex, int weight)
    {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.weight = weight;
    }

    public Edge(char firstVertexName, char secondVertexName, int weight)
    {
        this.firstVertex = new Vertex(firstVertexName);
        this.secondVertex = new Vertex(secondVertexName);
        this.weight = weight;
    }

    //weigth getters and setters
    public int getWeight()
    {
        return this.weight;
    }
    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    //first vertex getters and setters
    public Vertex getFirstVertex()
    {
        return this.firstVertex;
    }
    public void setFirstVertex(Vertex vertex)
    {
        this.firstVertex = vertex;
    }

    //second vertex getters and setters
    public Vertex getSecondVertex()
    {
        return this.secondVertex;
    }
    public void getSecondVertex(Vertex vertex)
    {
        this.secondVertex = vertex;
    }


    protected int weight;
    protected Vertex firstVertex;
    protected Vertex secondVertex;

    protected String edgeName;
}
