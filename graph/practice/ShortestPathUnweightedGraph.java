package graph.practice;

import java.util.*;

public class ShortestPathUnweightedGraph {

    private static void solve(int A, int[][] B, int src) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=1;i<=A;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<B.length;i++) {
            graph.get(B[i][0]).add(B[i][1]);
            graph.get(B[i][1]).add(B[i][0]);
        }
        boolean[] visited = new boolean[A+1];
        int[] dist = new int[A+1];
        bfs(src, graph, visited, dist);
        for (int i=1;i<=A;i++) {
            System.out.println(src + " - " + i + ": " + dist[i]);
        }
    }

    private static void bfs(int src, Map<Integer, Set<Integer>> graph, boolean[] visited, int[] dist) {
        visited[src] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            int d = dist[u];
            Set<Integer> neighbors = graph.get(u);
            for (int v : neighbors) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = d + 1;
                    queue.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        int A = 9;
        int[][] B = {
                {1,2},
                {2,3},
                {3,6},
                {1,4},
                {4,5},
                {5,6},
                {6,7},
                {7,8},
                {8,9},
        };
        solve(A,B,5);
    }
}
