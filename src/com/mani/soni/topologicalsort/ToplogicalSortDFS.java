package com.mani.soni.topologicalsort;

import java.util.*;

/**
 *  Time Complexity: O(V + E)
 */
public class ToplogicalSortDFS {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(5, List.of(0, 2));
            put(4, List.of(0, 1));
            put(2, List.of(3));
            put(1, new ArrayList<>());
            put(3, List.of(1));
            put(0, new ArrayList<>());
        }};

        topologicalSort(graph);

    }

    private static void topologicalSort(Map<Integer, List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();

        Set<Integer> set = new HashSet<>();

        for(Map.Entry<Integer, List<Integer>> maps: graph.entrySet()) {
            if(!set.contains(maps.getKey())) {
                dfsTraversal(maps.getKey(), graph, stack, set);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void dfsTraversal(Integer key, Map<Integer, List<Integer>> graph, Stack<Integer> stack, Set<Integer> set) {

        set.add(key);
        for (Integer neighbour : graph.get(key)) {
            if(!set.contains(neighbour)) {
                dfsTraversal(neighbour, graph, stack, set);
            }
        }
        // once we process all its neighbours we will push them to the stack.
        stack.push(key);
    }
}
