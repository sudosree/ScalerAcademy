package graph.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TimeTakenToVisitNode {

  static class Edge {
    int node;
    int distance;

    Edge(int node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }

  static class PQItem {
    int node;
    int priority;
    int distance;
    int timeElapsed;

    PQItem(int node, int priority, int distance, int timeElapsed) {
      this.node = node;
      this.priority = priority;
      this.distance = distance;
      this.timeElapsed = timeElapsed;
    }
  }

  public static int[] findTimeTaken(int N, int[][] edges, int[] priority) {
    Map<Integer, Set<Edge>> graph = new HashMap<>();
    for (int i=0; i<N; i++) {
      graph.put(i, new HashSet<>());
    }
    for (int i=0; i<edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int dist = edges[i][2];
      graph.get(u).add(new Edge(v, dist));
      graph.get(v).add(new Edge(u, dist));
    }
    boolean[] visited = new boolean[N];
    int[] timeToReach = new int[N];

    Queue<PQItem> pq = new PriorityQueue<>(new MyComparator());
    // add all the neighbors of node 0 to the priority queue
    for (Edge neighbor : graph.get(0)) {
      pq.offer(new PQItem(neighbor.node, priority[neighbor.node], neighbor.distance, 0));
    }
    visited[0] = true;

    while (!pq.isEmpty()) {
      PQItem pqItem = pq.poll();
      int currNode = pqItem.node;
      int dist = pqItem.distance;
      int timeElapsedByParentNode = pqItem.timeElapsed;

      // mark the node as visited
      visited[currNode] = true;
      int timeElapsedByCurrentNode = timeElapsedByParentNode + dist;
      timeToReach[currNode] = timeElapsedByCurrentNode;

      // add all the unvisited neighbors to the priority queue
      for (Edge neighbor : graph.get(currNode)) {
        if (!visited[neighbor.node]) {
          pq.offer(new PQItem(neighbor.node, priority[neighbor.node], neighbor.distance, timeElapsedByCurrentNode));
        }
      }
    }
    return timeToReach;
  }

  static class MyComparator implements Comparator<PQItem> {

    public int compare(PQItem pq1, PQItem pq2) {
      if (pq1.priority != pq2.priority) {
        return pq2.priority - pq1.priority;
      } else {
        return pq1.distance - pq2.distance;
      }
    }
  }

  public static void main(String[] args) {
    int N = 5;
    int[][] edges = {
        {0,1,2}, {1,3,1},
        {0,2,3}, {2,4,4}
    };
    int[] priority = {0, 5, 3, 1, 2};
    int[] result = findTimeTaken(N, edges, priority);
    for (int i = 1; i < N; i++) {
      System.out.println("Time to reach node " + i + ": " + result[i]);
    }
  }
}
