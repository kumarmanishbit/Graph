# Graph

A graph organizes items in an interconnected network. Each item is a node (or vertex). Nodes are connected by edges.

Strengths:
Representing links. Graphs are ideal for cases where you're working with things that connect to other things. 
Nodes and edges could, for example, respectively represent cities and highways, routers and ethernet cables, 
or Facebook users and their friendships. 

Weaknesses:
Scaling challenges. Most graph algorithms are O(n ∗ lg(n)) or even slower. Depending on the size of your graph, 
running algorithms across your nodes may not be feasible.

Graph Representation:
1. Edge list
2. Adjacency list
3. Adjacency matrix

### Edge list
```java
int[][] graph = {{0, 1}, {1, 2}, {3, 1}, {2, 3}};
```

### Adjacency list
```java

Map<Integer, List<Integer>> graph = new HashMap<>() {
    {
        put(0, Arrays.asList(1));
        put(1, Arrays.asList(0, 2, 3));
        put(2, Arrays.asList(1, 3));
        put(3, Arrays.asList(1, 2));
} };

```

### Adjacency matrix:

```java
int[][] graph = {
       {0, 1, 0, 0},
       {1, 0, 1, 1},
       {0, 1, 0, 1},
       {0, 1, 1, 0},
};
```