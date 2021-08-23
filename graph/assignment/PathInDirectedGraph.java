package graph.assignment;

import java.util.*;

public class PathInDirectedGraph {

    private static int solve(int A, int[][] B) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[A+1];
        for (int i=1;i<=A;i++) {
            graph.put(i, new LinkedHashSet<>());
        }
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            graph.get(u).add(v);
        }
        bfs(1, graph, visited);
        return visited[A] ? 1 : 0;
    }

    /**
     * TC = O(V+E), SC = O(V)
     * @param src
     * @param graph
     * @param visited
     */
    private static void bfs(int src, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        visited[src] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            Set<Integer> nodes = graph.get(u);
            for (int v : nodes) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    private void dfs(int u, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        visited[u] = true;
        Set<Integer> neighbors = graph.get(u);
        for (int v : neighbors) {
            if (!visited[v]) {
                dfs(v, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {
                {1,2},
                {1,3},
                {2,3},
                {1,4},
                {4,3},
                {4,5},
                {3,5}
        };
        System.out.println(solve(A,B));
    }
}
