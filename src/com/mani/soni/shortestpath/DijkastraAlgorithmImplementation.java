package com.mani.soni.shortestpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dijkstra's Algorithm: Finds the shortest path from one node to all other nodes in a weighted graph.
 * Time Complexity: O(V + E) logV
 *
 * Dijkstra's Algorithm does not work on the negative edges.
 * We can use Dijkstra's Algorithm on both directed and undirected graph.
 */
public class DijkastraAlgorithmImplementation {

    public static void main(String[] args) {
        // adjacency matrix of undirected graph.
        Integer[][] graph = {
                {0, 5, 10, 0},
                {5, 0, 3, 20},
                {10, 3, 0, 2},
                {0, 20, 2, 0}
        };
        Integer source = 0;

    }
}
