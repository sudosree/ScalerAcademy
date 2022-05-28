package graph.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {

    public static int knight(int A, int B, int C, int D, int E, int F) {
        int[][] grid = new int[A][B];
        // mark all the cells as -1 to indicate it is not yet processed
        // this is to avoid the visited array
        for (int i=0; i<A; i++) {
            Arrays.fill(grid[i], -1);
        }
        // mark the starting position as 0 to indicate that it is visited
        grid[C][D] = 0;
        int[] row = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] col = {-1, 1, -2, 2, -2, 2, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{C, D});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int p = pair[0];
            int q = pair[1];
            // reach the target cell
            if (p == E && q == F) {
                return grid[E][F];
            }
            for (int k=0; k<8; k++) {
                int i = row[k] + p;
                int j = col[k] + q;
                // if the cell is valid and not yet visited
                if (isValid(i, j, A, B) && grid[i][j] == -1) {
                    grid[i][j] = grid[p][q] + 1;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        int A = 8, B = 8;
        int C = 0, D = 0;
        int E = 7, F = 7;
        System.out.println(knight(A, B, C, D, E, F));
    }
}
