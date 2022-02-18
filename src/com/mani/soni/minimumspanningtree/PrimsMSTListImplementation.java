package com.mani.soni.minimumspanningtree;

import java.util.*;

public class PrimsMSTListImplementation {

    public static void main(String[] args) {
        Map<Integer, List<AdjacencyNode>> graph = new HashMap<>() {{
            put(0, List.of(new AdjacencyNode(1, 1), new AdjacencyNode(2, 3), new AdjacencyNode(3, 4)));
            put(1, List.of(new AdjacencyNode(0, 1), new AdjacencyNode(2, 2)));
            put(2, List.of(new AdjacencyNode(1, 2), new AdjacencyNode(3, 5)));
            put(3, List.of(new AdjacencyNode(0, 4), new AdjacencyNode(2, 5)));
        }};

        System.out.println(findMST(graph));
    }

    private static int findMST(Map<Integer, List<AdjacencyNode>> graph) {

        Set<Integer> mstSet = new HashSet<>();
        Node[] key = new Node[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            key[i] = new Node(i, Integer.MAX_VALUE);
        }
        key[0].key = 0;

        mstSet.add(0);

        Queue<Node> queue = new PriorityQueue<>();

        int res = 0;

        for (int i = 0; i < graph.size(); i++) {
            queue.add(key[i]);
        }

        // Loops until the queue is not empty
        while(!queue.isEmpty()) {
            // Extracts a node with min key value
            Node node = queue.poll();
            // Include that node into mstSet
            mstSet.add(node.vertex);
            res += node.key;

            // For all adjacent vertex of the extracted vertex V
            for(AdjacencyNode neighbour: graph.get(node.vertex)) {

                // If vertex is in the queue
                if(!mstSet.contains(neighbour.vertex)) {

                    // If the key value of the adjacent vertex is
                    // more than the extracted key
                    // update the key value of adjacent vertex
                    // to update first remove and add the updated vertex
                    if(key[neighbour.vertex].key > neighbour.weight) {
                        queue.remove(key[neighbour.vertex]);
                        key[neighbour.vertex].key = neighbour.weight;
                        queue.add(key[neighbour.vertex]);
                    }
                }
            }
        }

        return res;
    }

    private static class AdjacencyNode {
        int vertex;
        int weight;

        AdjacencyNode(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node>{
        Integer vertex;
        Integer key;

        public Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }

        public int compareTo(Node o) {
            return this.key.compareTo(o.key);
        }
    }
}
