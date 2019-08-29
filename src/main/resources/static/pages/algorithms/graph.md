:palm_tree: [Interview Questions](https://kellylin1115.github.io/interview-questions-blog/)

🌿 [Algorithms](index-algorithms.md)

# Graph
## 1. Breadth First Search (BFS)
Breadth First Traversal (or Search) for a graph may contain cycles, so we may come to the same node again. To avoid processing a node more than once, we use a boolean visited array. For simplicity, it is assumed that all vertices are reachable from the starting vertex.

For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0. If we don’t mark visited vertices, then 2 will be processed again and it will become a non-terminating process. A Breadth First Traversal of the following graph is 2, 0, 3, 1.
![](../../images/algorithms/bfs.png)

[BreadthFirstSearchGraph](../../../../java/com/kellylin1115/interview/algorithms/graph/BreadthFirstSearchGraph.java)

## 2. Depth First Search (DFS)
Depth First Traversal (or Search) for a graph may contain cycles, so we may come to the same node again. To avoid processing a node more than once, we use a boolean visited array.

For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0. If we don’t mark visited vertices, then 2 will be processed again and it will become a non-terminating process. A Depth First Traversal of the following graph is 2, 0, 1, 3.
![](../../images/algorithms/dfs.png)

[DepthFirstSearchGraph](../../../../java/com/kellylin1115/interview/algorithms/graph/DepthFirstSearchGraph.java)

## 3. Shortest Path from source to all vertices **Dijkstra** 
Shortest paths. An edge-weighted digraph is a digraph where we associate weights or costs with each edge. A shortest path from vertex s to vertex t is a directed path from s to t with the property that no other such path has a lower weight.
![](../../images/algorithms/shortest-path.png)


