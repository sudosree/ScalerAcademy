package graph.practice;

public class BinaryMatrixRegion {

    private static int region = 0, count = 0;
    private static int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int solve(int[][] A) {
        int n = A.length, m = A[0].length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, n, m);
                    region = Math.max(region, count);
                    count = 0;
                }
            }
        }
        return region;
    }

    private static void dfs(int[][] A, int i, int j, int n, int m) {
        A[i][j] = 0;
        count++;
        // visit all its 8 neighbors
        for (int k=0;k<8;k++) {
            int p = row[k] + i;
            int q = col[k] + j;
            if (isValid(p, q, n, m) && A[p][q] == 1) {
                dfs(A, p, q, n, m);
            }
        }
    }

    private static boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && i < n) && (j >= 0 && j < m);
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 0, 0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0}
        };

        System.out.println(solve(A));
    }
}
