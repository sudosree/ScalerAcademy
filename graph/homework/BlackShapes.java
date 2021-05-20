package graph.homework;

public class BlackShapes {

    public int black(String[] A) {
        int n = A.length;
        int m = A[0].length();
        char[][] mat = new char[n][m];
        for (int i=0;i<n;i++) {
            String s = A[i];
            for (int j=0;j<m;j++) {
                char c = s.charAt(j);
                mat[i][j] = c;
            }
        }
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (!visited[i][j] && mat[i][j] == 'X') {
                    dfs(i, j, mat, n, m, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] mat, int n, int m, boolean[][] visited) {
        visited[i][j] = true;
        int[] R = {-1, 0, 0, 1};
        int[] C = {0, -1, 1, 0};
        for (int k=0;k<4;k++) {
            int p = i + R[k];
            int q = j + C[k];
            if (isValid(p, n) && isValid(q, m) && mat[p][q] == 'X' && !visited[p][q]) {
                dfs(p, q, mat, n, m, visited);
            }
        }
    }

    private boolean isValid(int i, int n) {
        return i >= 0 && i < n;
    }
}
