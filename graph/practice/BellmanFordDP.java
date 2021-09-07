package graph.practice;

import java.util.Arrays;

public class BellmanFordDP {

    /**
     * TC = O(VE), SC = O(VE)
     * @param n
     * @param graph
     * @param src
     */
    private static void bellmanFord(int n, int[][] graph, int src) {
        int[][] dist = new int[n][n];
        for (int i=0;i<n;i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        // shortest distance from src to src using at most 0 edge
        dist[0][src] = 0;

        // shortest distance from src to all the other vertices
        // using at most i edges
        for (int i=1; i<n; i++) {
            // shortest distance from src to src using at most i edges
            dist[i][src] = 0;
            for (int[] edge : graph) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[i-1][u] != Integer.MAX_VALUE && dist[i-1][u] + w < dist[i][v]) {
                    dist[i][v] = dist[i-1][u] + w;
                }
            }
        }
        for (int i=0; i<n; i++) {
            System.out.println(src + " - " + i + ": " + dist[n-1][i]);
        }
    }

    private static void bellmanFord1(int n, int[][] graph, int src) {
        int[] prev = new int[n];
        int[] curr = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        Arrays.fill(curr, Integer.MAX_VALUE);
        // shortest distance from src to src using at most 0 edge
        prev[src] = 0;

        // shortest distance from src to all the other vertices
        // using at most i edges
        for (int i=1; i<n; i++) {
            // shortest distance from src to src using at most i edges
            curr[src] = 0;
            for (int[] edge : graph) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (prev[u] != Integer.MAX_VALUE && prev[u] + w < curr[v]) {
                    curr[v] = prev[u] + w;
                }
            }
            prev = curr.clone();
        }
        for (int i=0; i<n; i++) {
            System.out.println(src + " - " + i + ": " + prev[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0,1,1},
                {0,2,5},
                {1,2,1},
                {2,3,1},
        };
        int n = 4, src = 0;
        bellmanFord(n, graph, src);
        System.out.println();
        bellmanFord1(n, graph, src);
    }
}
