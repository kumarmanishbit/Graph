package com.mani.soni.shortestpath;

import java.util.*;

public class ShortestPathWithNoEdges {

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

        shortestPath(graph, 0);
    }

    /**
     * @param graph graph data structure
     * @param vertex Add the shortest path from source to every other vertex.
     */
    private static void shortestPath(Map<Integer, List<Integer>> graph, int vertex) {
        Integer[] path = new Integer[graph.size()];
        Arrays.fill(path, Integer.MAX_VALUE);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(vertex);
        Set<Integer> set = new HashSet<>();
        set.add(vertex);
        path[vertex] = 0;

        while (!deque.isEmpty()) {
            Integer v = deque.poll();
            List<Integer> neighbour = graph.get(v);
            for (Integer n : neighbour) {
                if (set.add(n)) {
                    path[n] = Math.min(path[n], path[v] + 1);
                    deque.add(n);
                    set.add(n);
                }
            }
        }

        for (Integer i : path) {
            System.out.println(i);
        }

    }
}
