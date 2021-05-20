package graph.practice;

import java.util.Arrays;

public class DijkstraDenseGraph {

    /**
     * TC = O(V^2 + E), SC = O(V)
     */
    private static void solve(int A, int[][] B, int src) {
        int[][] graph = new int[A+1][A+1];
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            graph[u][v] = w;
            graph[v][u] = w;
        }
        // keep track of the vertices that are included in the shortest path tree
        boolean[] sp = new boolean[A+1];
        int[] dist = new int[A+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i=1;i<A;i++) {
            // for each iteration it selects a vertex u that is not part
            // of the shortest path tree and is also the smallest dist from src
            int min = Integer.MAX_VALUE;
            int u = -1;
            for (int j=1;j<=A;j++) {
                if (!sp[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            sp[u] = true;
            for (int v=1;v<=A;v++) {
                if (graph[u][v] != 0 && !sp[v] && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        for (int i=1;i<=A;i++) {
            System.out.println(src + " - " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int A = 8;
        int[][] B = {
                {1,2,6},
                {2,3,2},
                {3,6,3},
                {5,6,5},
                {4,5,3},
                {1,4,3},
                {2,5,2},
                {6,7,5},
                {7,8,3},
        };
        solve(A,B,5);
    }
}
