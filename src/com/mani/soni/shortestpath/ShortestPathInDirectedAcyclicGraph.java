package com.mani.soni.shortestpath;

import java.util.*;

/**
 * We can use topological sort to find the edges which we have to
 * follow.
 */
public class ShortestPathInDirectedAcyclicGraph {

    private static class AdjacencyNode {
        int vertex;
        int weight;

        AdjacencyNode(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<AdjacencyNode>> graph = new HashMap<>() {{
            put(5, List.of(new AdjacencyNode(3, 1)));
            put(4, List.of(new AdjacencyNode(2, 2), new AdjacencyNode(5, 4)));
            put(2, List.of(new AdjacencyNode(3, 6)));
            put(1, List.of(new AdjacencyNode(2, 3)));
            put(3, new ArrayList<>());
            put(0, List.of(new AdjacencyNode(1, 2), new AdjacencyNode(4, 1)));
        }};

        findShortestPath(graph, 0);
    }

    private static void findShortestPath(Map<Integer, List<AdjacencyNode>> graph, int i) {
        // find topological sort
        topologicalSort(graph);

    }

    private static void topologicalSort(Map<Integer, List<AdjacencyNode>> graph) {

        Stack<Integer> stack = new Stack<>();

        Set<Integer> visited = new HashSet<>();

        for(Map.Entry<Integer, List<AdjacencyNode>> maps: graph.entrySet()) {
            if(!visited.contains(maps.getKey())) {
                dfsTraversal(graph, maps.getKey(), visited, stack);
            }
        }

        int starting = 0;
        computeShortestDistance(graph, stack, starting);
    }

    private static void computeShortestDistance(Map<Integer, List<AdjacencyNode>> graph, Stack<Integer> stack, Integer starting) {
        Integer[] distance = new Integer[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[starting] = 0;

        while(!stack.isEmpty()) {
            Integer vertex = stack.pop();
            // distance[vertex]
            for (AdjacencyNode node: graph.get(vertex)) {
                distance[node.vertex] = Math.min(distance[node.vertex], distance[vertex] + node.weight);
            }
        }

        for (Integer dist : distance) {
            System.out.println(dist);
        }

    }

    private static void dfsTraversal(Map<Integer, List<AdjacencyNode>> graph, Integer key, Set<Integer> visited, Stack<Integer> stack) {
             visited.add(key);

             for(AdjacencyNode neighbour : graph.get(key)) {
                 if(!visited.contains(neighbour.vertex)) {
                     dfsTraversal(graph, neighbour.vertex, visited, stack);
                 }
             }

             stack.push(key);
    }
}
