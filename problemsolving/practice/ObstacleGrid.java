package problemsolving.practice;

public class ObstacleGrid {

    private static int minDist = Integer.MAX_VALUE;

    private static int findMinDistance(int[][] path) {
        int m = path.length, n = path[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] row = {-1, 0, 0, 1};
        int[] col = {0, -1, 1, 0};
        int dist = 0;
        dfs(0, 0, path, m, n, visited, dist, row, col);
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private static void dfs(int i, int j, int[][] path, int m, int n, boolean[][] visited, int dist, int[] row, int[] col) {
        visited[i][j] = true;
        for (int k=0;k<4;k++) {
            int p = row[k] + i;
            int q = col[k] + j;
            if (isValid(p,q,m,n) && path[p][q] == 9) {
                dist++;
                minDist = Math.min(minDist, dist);
                return;
            }
            if (isValid(p,q,m,n) && path[p][q] == 1 && !visited[p][q]) {
                dist++;
                dfs(p, q, path, m, n, visited, dist, row, col);
            }
        }
    }

    private static boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && i < m) && (j >= 0 && j < n);
    }

    public static void main(String[] args) {
        int[][] path = {
                {1,1,1},
                {1,0,1},
                {1,9,1},
        };
        System.out.println(findMinDistance(path));
    }
}
