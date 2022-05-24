package org.rshu.app;

import org.rshu.graph.Edge;
import org.rshu.graph.Graph;
import org.rshu.graph.SpanningTree;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleApp {
    private Scanner scanner;
    private Graph graph;
    private SpanningTree spanningTree;
    /**
     * Basic Constructor
     */
    public ConsoleApp() {
        this.scanner = new Scanner(System.in);
        this.graph = new Graph();
    }

    /**
     * Runs an application
     */
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
    private void consoleRead() {
        String result = scanner.nextLine();
        System.out.println("Fill the edges or... \nType 3 to finish filling the Graph");
        while (!result.equals(Options.finishOption.getOption())) {
            result = this.scanner.nextLine();
            String edge = validateInput(result);
            if (!edge.equals("")) {
                try {
                    this.graph.addEdge(new Edge(edge));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        this.spanningTree = new SpanningTree(this.graph);
        this.spanningTree.printSpanningTree();
    }

    private void fileRead() {

        FileDialog dialog = new FileDialog(new Frame(), "Take a file", FileDialog.LOAD);
        dialog.setFile("*.txt");
        dialog.setModal(true);
        dialog.setVisible(true);
        File file = dialog.getFiles()[0];

        try {
            this.scanner = new Scanner(file);
            while (this.scanner.hasNextLine()) {
                String readenLine = this.scanner.nextLine();
                String edge = validateInput(readenLine);
                if (!edge.equals("")) {
                    try {
                        this.graph.addEdge(new Edge(edge));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            this.spanningTree = new SpanningTree(this.graph);
            this.spanningTree.printSpanningTree();
        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        }
    }

    private String validateInput(String line) {
        Pattern edgePattern = Pattern.compile("[A-Z][A-Z]\\s\\d+");
        Matcher matcher = edgePattern.matcher(line);
        try {
            boolean isFound = matcher.find();
            return matcher.group();
        } catch (Exception e) {
            return "";
        }
    }
}
