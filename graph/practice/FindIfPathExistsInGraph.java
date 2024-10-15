package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindIfPathExistsInGraph {

  /**
   * TC = O(m + n)
   * SC = O(m + n + n) = O(m+n)
   * @param n
   * @param edges
   * @param source
   * @param destination
   * @return
   */
  public static boolean validPath(int n, int[][] edges, int source, int destination) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i=0; i<n; i++) {
      graph.put(i, new HashSet<>());
    }
    for (int i=0; i<edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    boolean[] visited = new boolean[n];
    return dfs(source, destination, graph, visited);
  }

  private static boolean dfs(int source, int destination, Map<Integer, Set<Integer>> graph, boolean[] visited) {
    visited[source] = true;
    if (source == destination) {
      return true;
    }
    Set<Integer> neighbors = graph.get(source);
    for (int v : neighbors) {
      if (!visited[v]) {
        if (dfs(v, destination, graph, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] edges = {
        {0,1}, {1,2}, {2,0}
    };
    int source = 0, destination = 2;
    System.out.println(validPath(n, edges, source, destination));
  }

}
