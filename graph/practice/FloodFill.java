package graph.practice;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] row = {-1, 0, 0, 1};
        int[] col = {0, -1, 1, 0};
        dfs(sr, sc, newColor, image, m, n, visited, row, col);
        return image;
    }

    private void dfs(int i, int j, int color, int[][] image, int m, int n, boolean[][] visited, int[] row, int[] col) {
        visited[i][j] = true;
        int num = image[i][j];
        image[i][j] = color;
        for (int k=0;k<4;k++) {
            int p = row[k] + i;
            int q = col[k] + j;
            if (isValid(p, q, m, n) && image[p][q] == num && !visited[p][q]) {
                dfs(p, q, color, image, m, n, visited, row, col);
            }
        }
    }

    private boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && i < m) && (j >= 0 && j < n);
    }
}
