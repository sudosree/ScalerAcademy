package graph.practice;

import java.util.Arrays;

public class PrimMSTDenseGraph {

    /**
     * TC = O(V^2), SC = O(V)
     * @param A
     * @param B
     */
    private static void solve(int A, int[][] B) {
        int[][] graph = new int[A+1][A+1];
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            graph[u][v] = w;
            graph[v][u] = w;
        }
        int[] key = new int[A+1];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[1] = 0;
        boolean[] mst = new boolean[A+1];
        int[] parent = new int[A+1];
        parent[1] = -1;

        for (int i=1;i<A;i++) {
            int min = Integer.MAX_VALUE;
            int u = -1;
            for (int j=1;j<=A;j++) {
                if (!mst[j] && key[j] < min) {
                    min = key[j];
                    u = j;
                }
            }
            mst[u] = true;
            for (int v=1;v<=A;v++) {
                if (graph[u][v] != 0 && !mst[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        for (int i=2;i<=A;i++) {
            System.out.println(parent[i] + " - " + i + ": " + key[i]);
        }
    }

    public static void main(String[] args) {
        int A = 6;
        int[][] B = {
                {1,2,7},
                {1,6,8},
                {2,3,6},
                {2,6,3},
                {3,6,4},
                {3,4,5},
                {3,5,2},
                {4,5,5},
                {5,6,3}
        };
        solve(A, B);
    }
}
