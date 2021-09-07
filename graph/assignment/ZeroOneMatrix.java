package graph.assignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // first process all the 0 cells and put them into the queue
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    // mark all the 1 cells as unprocessed
                    mat[i][j] = -1;
                }
            }
        }
        int[] row = {-1, 0, 0, 1};
        int[] col = {0, -1, 1, 0};
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int r = pair[0];
            int c = pair[1];
            for (int k=0; k<4; k++) {
                int p = r + row[k];
                int q = c + col[k];
                if (p < 0 || p >= m || q < 0 || q >= n || mat[p][q] != -1) {
                    continue;
                }
                mat[p][q] = mat[r][c] + 1;
                queue.offer(new int[]{p, q});
            }
        }
        return mat;
    }

    public static int[][] updateMatrix1(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int inf = m + n;
        // find the nearest distance of each cell with 1 from cell 0
        // from its top and left neighbors
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    mat[i][j] = 0;
                    continue;
                }
                int top = inf, left = inf;
                if (i-1 >= 0) {
                    top = mat[i-1][j];
                }
                if (j-1 >= 0) {
                    left = mat[i][j-1];
                }
                mat[i][j] = Math.min(top, left) + 1;
            }
        }

        // find the nearest distance of each cell with 1 from cell 0
        // from its bottom and right neighbors
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                int bottom = inf, right = inf;
                if (i+1 < m) {
                    bottom = mat[i+1][j];
                }
                if (j+1 < n) {
                    right = mat[i][j+1];
                }
                mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {1,1,1},
        };
        System.out.println(Arrays.deepToString(updateMatrix1(mat)));
    }
}
