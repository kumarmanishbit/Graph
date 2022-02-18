package com.mani.soni.minimumspanningtree;

import java.util.Arrays;

/**
 *  This is a greedy algorithm which finds MST in a graph.
 *  It maintains two set, one set with vertices in MST, another one with vertices NOT in MST.
 */
public class PrimsMSTImplementation {

    public static void main(String[] args) {
        Integer graph[][] = new Integer[][] { { 0, 5, 8, 0},
                { 5, 0, 10, 15 },
                { 8, 10, 0, 20 },
                { 0, 15, 20, 0 },};

        System.out.print(findMSTLength(graph));
    }
    public static int findMSTLength(Integer[][] graph) {
        boolean[] mstSet = new boolean[graph.length];
        Integer[] key = new Integer[graph.length];
        int res = 0;
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        // we have to iterate for number of vertices.
        for (int i = 0; i < graph.length; i++) {
            int u = -1;
            // find the next candidate of the spanning tree.
            for (int j = 0; j < graph.length; j++) {
                if(!mstSet[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }

            mstSet[u] = true;
            res += key[u];
            for (int v = 0; v < graph.length; v++) {
                if(graph[u][v] != 0 && !mstSet[v]) {
                    key[v] = Math.min(key[v], graph[u][v]);
                }
            }
        }
        return res;
    }
}
