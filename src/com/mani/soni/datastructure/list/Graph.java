package com.mani.soni.datastructure.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Integer, List<Integer>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(Integer v, Integer u) {
        List<Integer> neigh = graph.getOrDefault(v, new ArrayList<>());
        neigh.add(u);
        graph.put(v, neigh);
        neigh = graph.getOrDefault(u, new ArrayList<>());
        neigh.add(v);
        graph.put(u, neigh);
    }

    public void removeEdge(Integer v, Integer u) {
        graph.remove(v);
        graph.remove(u);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Map.Entry<Integer, List<Integer>> map : graph.entrySet()) {
            stringBuilder.append(map.getKey()+": ");

            for (Integer neighbour : map.getValue()) {
                stringBuilder.append(neighbour+" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
