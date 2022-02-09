package com.mani.soni.traversal;

import java.util.*;

/**
 * Breadth-first search (BFS) is a method for exploring a tree or graph. In a BFS, you first
 * explore all the nodes one step away, then all the nodes two steps away, etc.
 * Breadth-first search is like throwing a stone in the center of a pond. The nodes you explore "ripple out"
 * from the starting point
 */
public class BFSTraversal {

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

        bfs(graph, 0);
    }

    private static void bfs(Map<Integer, List<Integer>> graph, int i) {
        Set<Integer> set = new HashSet<>();

        for (Map.Entry<Integer, List<Integer>> map: graph.entrySet()) {
            if(set.add(map.getKey())) {
                bfsUtils(graph, map.getKey(), set);
            }
        }
    }

    private static void bfsUtils(Map<Integer, List<Integer>> graph, int i, Set<Integer> set) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(i);
        set.add(i);

        while (!deque.isEmpty()) {
            Integer v = deque.pop();
            System.out.print(v +", ");
            for (Integer neighbour : graph.getOrDefault(v, new ArrayList<>())) {
                if(set.add(neighbour)) {
                    deque.add(neighbour);
                }
            }
        }
    }
}
