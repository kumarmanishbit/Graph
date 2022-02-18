package com.mani.soni.kruskal;

import java.util.*;

/***
 * Algorithm:
 * Step 1) Sort all edges in increasing order.
 * Step 2) Initialise MST = {}, res = 0
 * Step 3) Check if adding the edge is not causing the cycle.
 * Step 4) return result.
 *
 * Note:- MST size should be V - 1.
 *
 * Represent graph in terms of edges.
 *
 * Implemented using Disjoint Set, Disjoint sets are sets whose intersection is the empty
 * set so it means that they don't have any element in common.
 *
 */
public class KruskalAlgorithm {

    public static void main(String[] args) {
        // We need Edge representation of the graph
        Edge[] graph = {new Edge(0, 1, 10),
                new Edge(0, 2, 8),
                new Edge(1, 2, 5),
                new Edge(1, 3, 3),
                new Edge(2, 3, 4),
                new Edge(2, 4, 12),
                new Edge(3, 4, 15),
        };

        findMST(graph);

    }

    private static void findMST(Edge[] graph) {
        Arrays.sort(graph);

        Subset[] subsets = new Subset[4];

        for(int i=0; i < 4; i++) {
            subsets[i] = new Subset();
            // Initially point parent to itself, and rank to 0.
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            Edge edge = graph[i];

            int u = find(subsets, edge.src);
            int v = find(subsets, edge.dest);

            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if(u != v) {
                union(subsets, v, v);
                result += edge.weight;
            }
        }

        System.out.println("Weight of MST is: "+result);
    }

    private static void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if(subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank){
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[yroot].rank++;
        }
    }

    // find root and make root as parent of vertex (path compression)
    private static int find(Subset[] subsets, int vertex) {

        if(vertex != subsets[vertex].parent) {
            subsets[vertex].parent = find(subsets, subsets[vertex].parent);
        }

        return subsets[vertex].parent;
    }

    static class Subset {
        Integer parent, rank;
    }

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
