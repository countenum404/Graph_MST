package org.rshu;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleApp {
    public ConsoleApp() {
        this.scanner = new Scanner(System.in);
        this.graph = new Graph();
    }
    public void run() {
        System.out.println("Read edges from console/file?\n 1. console \n 2. file");
        String result = this.scanner.next();
        if (result.equals(Options.consoleOption.getOption())) {
            this.consoleRead();
        }
        if (result.equals(Options.fileOption.getOption())) {
            this.fileRead();
        }
    }
    protected void consoleRead() {
        String result = scanner.nextLine();
        System.out.println("Fill the edges or... \nType 3 to finish filling the Graph");
        while (!result.equals(Options.finishOption.getOption())) {
            result = this.scanner.nextLine();
            String edge = findEdge(result);
            if (!edge.equals("")) {
                try {
                    this.addEdge(edge);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        printSpanningTree();
    }
    protected void fileRead() {
        System.out.println("Filename/Path is required: ");
        String result = this.scanner.next();
        try {
            this.scanner = new Scanner(new File(result));
            while (this.scanner.hasNextLine()) {
                String readenLine = this.scanner.nextLine();
                String edge = findEdge(readenLine);
                if (!edge.equals("")) {
                    try {
                        this.addEdge(edge);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            this.printSpanningTree();
        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        }
    }
    protected void printSpanningTree() {
        this.scanner.close();
        this.spanningTree = new SpanningTree(this.graph);
        System.out.println(this.spanningTree.getMinimalSpanningTreeString());
    }
    protected void addEdge(final String edge) {
        String[] split = edge.split(" ");
        this.graph.addEdge(new Edge(split[0], Integer.parseInt(split[1])));
    }

    protected String findEdge(final String line) {
        Pattern edgePattern = Pattern.compile("[A-Z][A-Z]\\s\\d+");
        Matcher matcher = edgePattern.matcher(line);
        try {
            boolean isFound = matcher.find();
            return matcher.group();
        } catch (Exception e) {
            return "";
        }
    }
    protected Scanner scanner;
    protected Graph graph;
    protected SpanningTree spanningTree;
}
