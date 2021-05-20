package graph.homework;

import java.util.ArrayList;

public class CaptureRegionsOnBoard {

    /**
     * TC = O(n * m), SC = O(n * m)
     * @param a
     */
    public void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size(), m = a.get(0).size();
        boolean[][] visited = new boolean[n][m];
        // 1st row
        for (int i=0;i<m;i++) {
            char c = a.get(0).get(i);
            if (c == 'O' && !visited[0][i]) {
                dfs(0, i, a, n, m, visited);
            }
        }
        // 1st column
        for (int i=0;i<n;i++) {
            char c = a.get(i).get(0);
            if (c == 'O' && !visited[i][0]) {
                dfs(i, 0, a, n, m, visited);
            }
        }
        // last row
        for (int i=0;i<m;i++) {
            char c = a.get(n-1).get(i);
            if (c == 'O' && !visited[n-1][i]) {
                dfs(n-1, i, a, n, m, visited);
            }
        }
        // last column
        for (int i=0;i<n;i++) {
            char c = a.get(i).get(m-1);
            if (c == 'O' && !visited[i][m-1]) {
                dfs(i, m-1, a, n, m, visited);
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                char c = a.get(i).get(j);
                if (c == 'O' && !visited[i][j]) {
                    a.get(i).set(j, 'X');
                }
            }
        }
    }

    private void dfs(int i, int j, ArrayList<ArrayList<Character>> a, int n, int m, boolean[][] visited) {
        visited[i][j] = true;
        int[] row = {-1, 0, 0, 1};
        int[] col = {0, -1, 1, 0};
        for (int k=0;k<4;k++) {
            int p = i + row[k];
            int q = j + col[k];
            if (isValid(p, n) && isValid(q, m) && a.get(p).get(q) == 'O' && !visited[p][q]) {
                dfs(p,q,a,n,m,visited);
            }
        }
    }

    private boolean isValid(int i, int n) {
        return i >= 0 && i < n;
    }
}
