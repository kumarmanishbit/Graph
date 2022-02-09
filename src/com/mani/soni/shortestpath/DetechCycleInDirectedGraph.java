package com.mani.soni.shortestpath;

import java.util.*;

/**
 * This can be done using BFS of DFS.
 * Time Complexity: O(V + E)
 */
public class DetechCycleInDirectedGraph {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(0, List.of(1));
            put(1, new ArrayList<>());
            put(2, List.of(1, 3));
            put(3, List.of(4));
            put(4, List.of(5));
            put(5, List.of(2));
        }};

        System.out.println(detectCycle(graph));
    }

    private static boolean detectCycle(Map<Integer, List<Integer>> graph) {

        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for(Map.Entry<Integer, List<Integer>> map: graph.entrySet()) {
            if(!visited.contains(map.getKey())) {
                /**
                 *  We have to pass -1 as parent in all the disconnected vertices.
                 */
                if(dfsUtils(graph, map.getKey(), visited, recursionStack)) {
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
     * @param recursionStack : is to maintain back edges in recursion call stack.
     * @return
     */
    private static boolean dfsUtils(Map<Integer, List<Integer>> graph, Integer key, Set<Integer> set, Set<Integer> recursionStack) {

        recursionStack.add(key);
        List<Integer> neighbour = graph.get(key);

        for (Integer v: neighbour) {
            if(set.add(v)) {
                if(dfsUtils(graph, v, set, recursionStack)) {
                    return true;
                }
            } else if(recursionStack.contains(v)){
                return true;
            }
        }
        recursionStack.remove(key);
        return false;
    }
}
