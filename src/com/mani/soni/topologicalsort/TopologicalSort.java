package com.mani.soni.topologicalsort;

import java.util.*;

/**
 * kahn's algorithm
 */
public class TopologicalSort {
    public static void main(String[] args) {

//        Map<Integer, List<Integer>> graph = new HashMap<>() {{
//            put(1, List.of(2, 3));
//            put(2, List.of(4, 5));
//            put(3, List.of(4));
//            put(4, List.of(5));
//            put(5, new ArrayList<>());
//        }};

        Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(5, List.of(0, 2));
            put(4, List.of(0, 1));
            put(2, List.of(3));
            put(1, new ArrayList<>());
            put(3, List.of(1));
            put(0, new ArrayList<>());
        }};
        Map<Integer, Integer> inDegree = inDegreeOfGraph(graph);

        Deque<Integer> nodesWithNoIncomingEdges = new ArrayDeque<>();
        List<Integer> topologicalOrdering = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entrySet: inDegree.entrySet()) {
            if(entrySet.getValue() == 0) {
                nodesWithNoIncomingEdges.add(entrySet.getKey());
            }
        }

        while(!nodesWithNoIncomingEdges.isEmpty()) {
            Integer node = nodesWithNoIncomingEdges.poll();
            topologicalOrdering.add(node);

            for (Integer neighbour: graph.get(node)) {
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                if(inDegree.get(neighbour) == 0) {
                    nodesWithNoIncomingEdges.add(neighbour);
                }
            }
        }

        // This is the case when we have cycle in the graph
        // and when there is cycle then at a certain point
        // we could not able to find vertices with 0 indegree.
        // i.e. there won't be any starting point.
        if(topologicalOrdering.size() != graph.size()) {
            System.out.println("Topological ordering is not possible!!!");
            return;
        }

        for(Integer i : topologicalOrdering) {
            System.out.print(i +" -> ");
        }

    }

    private static Map<Integer, Integer> inDegreeOfGraph(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entrySet: graph.entrySet()) {
            inDegree.put(entrySet.getKey(), inDegree.getOrDefault(entrySet.getKey(), 0));
            for(Integer neighbour: entrySet.getValue()) {
                Integer node = inDegree.getOrDefault(neighbour, 0);
                inDegree.put(neighbour, ++node);
            }
        }
        return inDegree;
    }
}
