package com.mani.soni.datastructure.matrix;

public class Graph {

    private boolean adj[][];
    private int numVertices;

    public Graph(int v) {
        this.numVertices = v;
        this.adj = new boolean[v][v];
    }

    public void addEdge(int i, int j) {
        adj[i][j] = true;
        adj[j][i] = true;
    }

    public void removeEdge(int i, int j) {
        adj[i][j] = false;
        adj[j][i] = false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < adj.length; i++) {
            stringBuilder.append(i +": ");
            for (boolean j : adj[i]) {
                stringBuilder.append((j ? 1 : 0 ) +" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
