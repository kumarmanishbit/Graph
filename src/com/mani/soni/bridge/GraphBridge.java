package com.mani.soni.bridge;

import java.util.*;

/**
 * An edge in a graph between vertices say  and  is called a Bridge, if after removing it,
 * there will be no path left between  and . It's definition is very similar to that of Articulation Points.
 * Just like them it also represents vulnerabilities in the given network.
 *
 */
public class GraphBridge {

    private static Integer time = 0;

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(0, List.of(1, 2));
            put(1, List.of(0, 2));
            put(2, List.of(0, 3));
            put(3, List.of(2, 4));
            put(4, new ArrayList<>());
        }};

        findBridge(graph);
    }

    private static void findBridge(Map<Integer, List<Integer>> graph) {

        Integer[] parent = new Integer[graph.size()];
        Integer[] discoveryTime = new Integer[graph.size()];
        Integer[] lowDiscoveryTime = new Integer[graph.size()];
        Set<Integer> set = new HashSet<>();
        int source = 0;
        bridgeUtils(graph, set, parent, source, discoveryTime, lowDiscoveryTime);
    }

    private static void bridgeUtils(Map<Integer, List<Integer>> graph, Set<Integer> set, Integer[] parent, int source, Integer[] discoveryTime, Integer[] lowDiscoveryTime) {

        set.add(source);
        discoveryTime[source] = lowDiscoveryTime[source] = ++time;

        for(Integer neighbour: graph.get(source)) {

            if(!set.contains(neighbour)) {
                parent[neighbour] = source;

                bridgeUtils(graph, set, parent, neighbour, discoveryTime, lowDiscoveryTime);
                lowDiscoveryTime[source] = Math.min(lowDiscoveryTime[source], lowDiscoveryTime[neighbour]);

                if (lowDiscoveryTime[neighbour] > discoveryTime[source]) {
                    System.out.println("Source : " + source + " Destination : " + neighbour);
                }
            } else if (neighbour != parent[source]) {
                lowDiscoveryTime[source] = Math.min(lowDiscoveryTime[source], discoveryTime[neighbour]);
            }
        }
    }
}
