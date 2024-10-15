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

    private int[][] directions = {
        {-1,0}, {0,-1}, {0,1}, {1,0}
    };

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        // start DFS from the border cells with value O and mark
        // those cells with value E

        // first row and last row
        for (int c=0; c<n; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c, board, m, n);
            }
            if (board[m-1][c] == 'O') {
                dfs(m-1, c, board, m, n);
            }
        }
        // first col and last col
        for (int r=0; r<m; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0, board, m, n);
            }
            if (board[r][n-1] == 'O') {
                dfs(r, n-1, board, m, n);
            }
        }
        // convert all the remaining Os to X and Es to O
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board, int m, int n) {
        board[r][c] = 'E';
        for (int[] d : directions) {
            int i = r + d[0];
            int j = c + d[1];
            if (isValid(i, j, m, n) && board[i][j] == 'O') {
                dfs(i, j, board, m, n);
            }
        }
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
