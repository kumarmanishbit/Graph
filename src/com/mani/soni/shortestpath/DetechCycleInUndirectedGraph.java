package com.mani.soni.shortestpath;

import java.util.*;

/**
 * This can be done using BFS of DFS.
 * Time Complexity: O(V + E)
 */
public class DetechCycleInUndirectedGraph {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(0, List.of(1, 2, 5));
            put(1, List.of(3));
            put(2, List.of(4));
            put(3, new ArrayList<>());
            put(4, new ArrayList<>());
            put(5, new ArrayList<>());
            put(6, new ArrayList<>());
        }};

        System.out.println(detectCycle(graph));
    }

    private static boolean detectCycle(Map<Integer, List<Integer>> graph) {
        Set<Integer> set = new HashSet<>();

        for(Map.Entry<Integer, List<Integer>> map: graph.entrySet()) {
            if(!set.contains(map.getKey())) {
                /**
                 *  We have to pass -1 as parent in all the disconnected vertices.
                 */
                if(dfsUtils(graph, map.getKey(), set, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param graph
     * @param key
     * @param set
     * @param parent:- this is  trick to find if we are coming from the same parent.
     * @return
     *
     */
    private static boolean dfsUtils(Map<Integer, List<Integer>> graph, Integer key, Set<Integer> set, int parent) {

        List<Integer> neighbour = graph.get(key);

        for (Integer v: neighbour) {
            if(set.add(v)) {
                if(dfsUtils(graph, v, set, key)) {
                    return true;
                }
            } else if(v != parent){
                return true;
            }
        }

        return false;
    }


}
