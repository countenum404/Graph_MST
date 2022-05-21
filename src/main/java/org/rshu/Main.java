package org.rshu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        System.out.println("Read edges from console/file?\n 1. console \n 2. file");
        String result = scanner.next();

        if (result.equals(Options.consoleOption.getOption()))
        {
            System.out.println("Fill the edges or... \nType 3 to finish filling the Graph");
            while(true)
            {
                result = scanner.nextLine();
                if (result.equals(Options.finishOption.getOption()))
                {
                    SpanningTree tree = new SpanningTree(graph);
                    System.out.println(tree.getMinimalSpanningTreeString());
                    break;
                }

                if(result.length() > 1)
                {
                    try
                    {
                        String[] splitted = result.split(" ");
                        graph.addEdge(new Edge(splitted[0], Integer.parseInt(splitted[1])));
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

        if (result.equals(Options.fileOption.getOption()))
        {

        }
    }
}