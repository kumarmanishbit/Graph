package com.mani.soni.minimumspanningtree;

import java.util.Arrays;

/**
 *  This is a greedy algorithm which finds MST in a graph.
 *  It maintains two set, one set with vertices in MST, another one with vertices NOT in MST.
 */
public class PrimsMSTImplementation {

    public void findMST(Integer[][] graph) {
        boolean[] mstSet = new boolean[graph.length];
        Integer[] key = new Integer[graph.length];
        int res = 0;
        Arrays.fill(key, Integer.MAX_VALUE);


    }
}
