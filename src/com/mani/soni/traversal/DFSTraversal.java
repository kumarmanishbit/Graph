package com.mani.soni.traversal;

import java.util.*;

/**
 * Time Complexity: O(V + E); where V is number of vertex, and E is number of edges
 * Depth-first search (DFS) is a method for exploring a tree or graph. In a DFS, you go
 * as deep as possible down one path before backing up and trying a different one.
 *
 * Advantages:
 *
 * Depth-first search on a binary tree generally requires less memory than breadth-first.
 * Depth-first search can be easily implemented with recursion.
 *
 * Disadvantages:
 * A DFS doesn't necessarily find the shortest path to a node,
 * while breadth-first search does.
 */
public class DFSTraversal {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(0, List.of(1, 2, 5));
            put(1, List.of(0, 3));
            put(2, List.of(0, 4));
            put(3, List.of(1, 5));
            put(4, List.of(2, 5));
            put(5, List.of(3, 4));
            put(6, new ArrayList<>());
        }};

        dfs(graph, 0);
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int i) {
        Set<Integer> set = new HashSet<>();
        // loop will help to traverse even disconnected graph
        for (Map.Entry<Integer, List<Integer>> map: graph.entrySet()) {
            if(!set.contains(map.getKey())) {
                dfsUtils(graph, map.getKey(), set);
            }
        }
    }

    private static void dfsUtils(Map<Integer, List<Integer>> graph, int i, Set<Integer> set) {
        System.out.println("Visit "+ i);
        set.add(i);
        // get the neighbour
        List<Integer> neighbour = graph.get(i);

        for (Integer v : neighbour) {
            if(!set.contains(v)) {
               dfsUtils(graph, v, set);
            }
        }
    }
}
