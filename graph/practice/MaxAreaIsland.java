package graph.practice;

public class MaxAreaIsland {

    private int[] row = {-1, 0, 0, 1};
    private int[] col = {0, -1, 1, 0};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(grid, i, j, m, n, visited, 0);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited, int area) {
        visited[i][j] = true;
        area++;
        for (int k=0; k<4; k++) {
            int p = i + row[k];
            int q = j + col[k];
            if (isValid(p, q, m, n) && grid[p][q] == 1 && !visited[p][q]) {
                area = dfs(grid, p, q, m, n, visited, area);
            }
        }
        return area;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
