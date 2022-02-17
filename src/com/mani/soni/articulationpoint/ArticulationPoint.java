package com.mani.soni.articulationpoint;

import java.util.*;

/**
 * Articulation point or cut vertices.
 * A vertex in an undirected connected graph is an articulation point (or cut vertex)
 * if removing it (and edges through it) disconnects the graph.
 *
 * We don't want any articulation point in the graph.
 */
public class ArticulationPoint {

    private static Integer time = 0;

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(0, List.of(1, 2));
            put(1, List.of(0, 2));
            put(2, List.of(0, 3));
            put(3, List.of(2, 4));
            put(4, new ArrayList<>());
        }};

        findArticulationPoint(graph);
    }

    private static void findArticulationPoint(Map<Integer, List<Integer>> graph) {
        boolean[] articulationPoint = new boolean[graph.size()];

        Set<Integer> visited = new HashSet<>();

        int source = 0;
        Integer[] discoverTime = new Integer[graph.size()];
        Integer[] lowestDiscoverTime = new Integer[graph.size()];

        Integer[] parent = new Integer[graph.size()];
        parent[source] = -1;
        articulationPointUtils(graph, source, visited, discoverTime, lowestDiscoverTime, parent, articulationPoint);

        for (int i= 0; i < articulationPoint.length;i++) {
            if(articulationPoint[i]) {
                System.out.println("Vertex "+i +" is articulation point!!!");
            }
        }
    }

    private static void articulationPointUtils(Map<Integer, List<Integer>> graph, int source, Set<Integer> visited, Integer[] discoverTime, Integer[] lowestDiscoverTime, Integer[] parent, boolean[] articulationPoint) {
//        visited.add(source);
        visited.add(source);
        lowestDiscoverTime[source] = discoverTime[source] = ++time;
        int children = 0;
        for(Integer neighbour: graph.get(source)) {

            if(!visited.contains(neighbour)) {
                children++;
                parent[neighbour] = source;
                articulationPointUtils(graph, neighbour, visited, discoverTime, lowestDiscoverTime, parent, articulationPoint);

                // When that DFS call will return,  will have the discovery time of the earliest discovered vertex that
                // can be reached from any vertex in the subtree rooted at v.
                // lowestDiscover[] will have the earliest discovery time
                lowestDiscoverTime[source] = Math.min(lowestDiscoverTime[source], lowestDiscoverTime[neighbour]);

                // We got an articulation point.
                if(parent[source] == -1 && children > 1) {
                    articulationPoint[source] = true;
                }

                // if  is not the root, it checks whether  is greater than or equal to ,
                // and if so, it marks  articulationPoint[source] as true.
                if(parent[source] != -1 && lowestDiscoverTime[neighbour] >= discoverTime[source]) {
                    articulationPoint[source] = true;
                }

            } else if(parent[source] != neighbour){
                // algorithm iterates over every vertex in the graph and see if it is connected to ,
                // if it finds a vertex . that is connected to , but has already been visited,
                // then it updates the value  to minimum of  and discovery time of  v i.e., disc[v]
                lowestDiscoverTime[source] = Math.min(lowestDiscoverTime[neighbour], discoverTime[source]);
            }
        }
    }
}
