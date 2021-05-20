package graph.assignment;

import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int n = B+1, m = A+1;
        int R = D;
        int[][] grid = new int[n][m];

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                grid[i][j] = 1;
            }
        }

        for (int k=0;k<C;k++) {
            // x coordinate
            int cx = E[k];
            // y coordinate
            int cy = F[k];
            cy = n-cy-1;
            // row
            for (int i=cy-R;i<=cy+R;i++) {
                // column
                for (int j=cx-R;j<=cx+R;j++) {
                    if (isValid(i, n) && isValid(j, m) && inCircle(j,i,cx,cy,R)) {
                        grid[i][j] = 0;
                    }
                }
            }
        }

        /*for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }*/

        if (grid[n-1][0] == 0 || grid[0][m-1] == 0) {
            return "NO";
        }
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(n-1, 0));
        visited[n-1][0] = true;
        bfs(n, m, grid, visited, queue);
        return visited[0][m-1] ? "YES" : "NO";

    }

    private static boolean isValid(int i, int n) {
        return i>=0 && i<n;
    }

    private static boolean inCircle(int x, int y, int cx, int cy, int R) {
        if ((cx - x) * (cx - x) + (cy - y) * (cy - y) - R * R <= 0) {
            return true;
        }
        return false;
    }

    private static void bfs(int n, int m, int[][] grid, boolean[][] visited, Queue<Pair> queue) {

        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!queue.isEmpty()) {
            Pair tmp = queue.poll();
            int i = tmp.x;
            int j = tmp.y;
            for (int k=0;k<8;k++) {
                int p = i+row[k];
                int q = j+col[k];
                if (isValid(p, n) && isValid(q, m) && grid[p][q] == 1 && !visited[p][q]) {
                    visited[p][q] = true;
                    queue.offer(new Pair(p,q));
                }
            }
        }
    }

    public static void main(String[] args) {
        int A = 2, B = 3, C= 1, D = 1;
        int[] E = {2};
        int[] F = {3};
        System.out.println(solve(A,B,C,D,E,F));
//        solve(A,B,C,D,E,F);
    }
}
