package graph.homework;

public class KingGraph {

    /**
     * TC = O(V^3)
     * @param A
     * @return
     */
    public static int solve(int[][] A) {
        int n = A.length;
        int[][] dist = new int[n+1][n+1];
        for (int i=0;i<n+1;i++) {
            for (int j=0;j<n+1;j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (A[i][j] != -1) {
                    dist[i+1][j+1] = A[i][j];
                }
            }
        }
        for (int k=1;k<=n;k++) {
            for (int i=1;i<=n;i++) {
                for (int j=1;j<=n;j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE, index = 0;
        for (int i=1;i<=n;i++) {
            int max = Integer.MIN_VALUE;
            for (int j=1;j<=n;j++) {
                if (dist[i][j] > max) {
                    max = dist[i][j];
                }
            }
            if (max < min) {
                min = max;
                index = i;
            }
        }
        return index-1;
    }

    public static void main(String[] args) {
        int[][] A = {
                {0,6,8,-1},
                {6,0,9,-1},
                {8,9,0,4},
                {-1,-1,4,0},
        };
        System.out.println(solve(A));
    }
}
