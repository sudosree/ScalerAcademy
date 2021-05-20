package graph.practice;

import java.util.*;

public class BellmanFord {

    static class Pair {
        int vertex;
        int weight;
        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    /**
     * TC = O(VE), SC = O(V)
     * @param A
     * @param B
     * @param src
     */
    private static void solve(int A, int[][] B, int src) {
        int[] dist = new int[A+1];
        Map<Integer, Set<Pair>> graph = new HashMap<>();
        for (int i=1;i<=A;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i=1;i<A;i++) {
            for (int u=1;u<=A;u++) {
                Set<Pair> neighbors = graph.get(u);
                for (Pair pair : neighbors) {
                    int v = pair.vertex;
                    int w = pair.weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        for (int u=1;u<=A;u++) {
            Set<Pair> neighbors = graph.get(u);
            for (Pair pair : neighbors) {
                int v = pair.vertex;
                int w = pair.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    System.out.println("Graph contains a negative weight cycle");
                    return;
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
