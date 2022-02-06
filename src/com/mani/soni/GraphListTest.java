package com.mani.soni;

import com.mani.soni.datastructure.list.Graph;

public class GraphListTest {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        System.out.println(graph.toString());
    }
}
