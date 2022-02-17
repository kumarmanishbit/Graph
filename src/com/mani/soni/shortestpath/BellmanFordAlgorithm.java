package com.mani.soni.shortestpath;

import java.util.Arrays;

/**
 *  This algorithm works event for negative edge cycle.
 *  This is a dynamic programming approach.
 */
public class BellmanFordAlgorithm {

    public static void main(String[] args) {
        Edge[] graph = {new Edge(0, 1, 1),
                new Edge(0, 2, 4),
                new Edge(1, 2, -3),
                new Edge(1, 3, 2),
                new Edge(2, 3, 3)
        };

        bellmanFord(graph, 0);
    }

    private static void bellmanFord(Edge[] graph, int source) {
        int dist[] = new int[4];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 0; i < 4; i++) {
            for(Edge edge: graph) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;

                if(dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for(Edge edge: graph) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;

            if(dist[v] > dist[u] + weight) {
                System.out.println("Negative Edge Found!!!");
            }
        }

        printDistance(dist);
    }

    private static void printDistance(int[] dist) {
        for(int d : dist) {
            System.out.println(d);
        }
    }
}

class Edge {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}