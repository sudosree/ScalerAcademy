package graph.homework;

public class SheldonAndPairOfCities {

    public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
        // create an adjacency matrix
        int[][] dist = new int[A+1][A+1];
        for (int i=0;i<A+1;i++) {
            for (int j=0;j<A+1;j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i=0;i<A+1;i++) {
            dist[i][i] = 0;
        }
        for (int i=0;i<B;i++) {
            int u = D[i];
            int v = E[i];
            int w = F[i];
            // multiple edges
            if (w < dist[u][v]) {
                dist[u][v] = w;
                dist[v][u] = w;
            }
        }
        for (int k=1;k<=A;k++) {
            for (int i=1;i<=A;i++) {
                for (int j=1;j<=A;j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int[] ans = new int[C];
        for (int i=0;i<C;i++) {
            int u = G[i];
            int v = H[i];
            int d = dist[u][v] == Integer.MAX_VALUE ? -1 : dist[u][v];
            ans[i] = d;
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 15;
        int B = 18;
        int C = 29;
        int[] D = {11, 2, 2, 6, 2, 8, 9, 3, 14, 15, 4, 14, 8, 7, 8, 6, 2, 12};
        int[] E = {2, 1, 1, 2, 1, 1, 7, 3, 2, 13, 2, 1, 6, 1, 7, 1, 2, 10};
    }
}
