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

    private static int[][] dirs = new int[][]{
        {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, m, n, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, int m, int n, char[][] grid) {
        // mark the cell as visited
        grid[r][c] = '0';
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                dfs(nr, nc, m, n, grid);
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = {
                {0, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 0, 1}
        };
        System.out.println(solve(A));
    }
}
