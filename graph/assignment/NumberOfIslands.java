package graph.assignment;

public class NumberOfIslands {

    private static int solve(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];

        // find the no. of connected components
        int count = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (A[i][j] == 1 && !visited[i][j]) {
                    // visit all the vertices starting from the vertex A[i][j]
                    visitNearByIslands(i, j, A, m, n, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void visitNearByIslands(int i, int j, int[][] A, int m, int n, boolean[][] visited) {
        visited[i][j] = true;
        // visit (i-1,j-1), (i-1,j), (i-1,j+1)
        // (i,j-1), (i,j+1)
        // (i+1,j-1), (i+1,j), (i+1,j+1)
        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k=0;k<8;k++) {
            int p = i+row[k];
            int q = j+col[k];
            if (isValid(p, m) && isValid(q, n) && A[p][q] == 1 && !visited[p][q]) {
                visitNearByIslands(p, q, A, m, n, visited);
            }
        }
    }

    private static boolean isValid(int i, int n) {
        return i >= 0 && i < n;
    }

    public static void main(String[] args) {
        int[][] A = {
                {0, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 0, 1}
        };
        System.out.println(solve(A));
    }
}
