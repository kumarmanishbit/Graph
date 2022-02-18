package com.mani.soni.component;

import java.util.*;

/**
 * Order the vertices in their decreasing order of finish time in DFS.
 * A Generic algorithm to process start time and finish time in the graph.
 */
public class DFSFinishTime {

    private static Integer time = 0;
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
        findTheStartAndFinishTimeOfDFS(graph);
    }

    private static void findTheStartAndFinishTimeOfDFS(Map<Integer, List<Integer>> graph) {
        Integer[] startTime = new Integer[graph.size()];
        Integer[] finishTime = new Integer[graph.size()];
        Set<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
            if(!visited.contains(entry.getKey())) {
                dfsTraverse(graph, entry.getKey(), visited, startTime, finishTime);
            }
        }

        for (int i = 0; i < startTime.length; i++) {
            System.out.println("Vertex: "+i +" StartTime: "+ startTime[i] + " Finish Time: "+finishTime[i]);
        }
    }

    private static void dfsTraverse(Map<Integer, List<Integer>> graph, Integer vertex, Set<Integer> visited, Integer[] startTime, Integer[] finishTime) {

        // when we are visiting the vertices we record the time.
        startTime[vertex] = ++time;
        visited.add(vertex);

        for (Integer neighbour: graph.get(vertex)) {
            if(!visited.contains(neighbour)) {
                dfsTraverse(graph, neighbour, visited, startTime, finishTime);
            }
        }
        // When we process the vertices we record the time.
        finishTime[vertex] = ++time;
    }
}
