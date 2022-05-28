package graph.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    private static int[] row = {-1, 0, 0, 1};
    private static int[] col = {0, -1, 1, 0};

    public static int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // will keep track of whether you have found the first island or not
        boolean found = false;
        for (int i=0; i<m; i++) {
            // if you found the first island then break out of the loop
            // no need to find the second island
            if (found) {
                break;
            }
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                // dfs to find the 1st island
                dfs(grid, i, j, m, n, queue);
                found = true;
                break;
            }
        }
        int distance = 0;
        // bfs to find the distance of 1st island till you reach the 2nd island
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] triplet = queue.poll();
                for (int k=0; k<4; k++) {
                    int p = row[k] + triplet[0];
                    int q = col[k] + triplet[1];
                    int color = triplet[2];
                    if (isValid(p, q, m, n)) {
                        // this is the start of the 2nd island
                        if (grid[p][q] == 1) {
                            return distance;
                        }
                        // not yet visited
                        else if (grid[p][q] == 0) {
                            grid[p][q] = color+1;
                            queue.offer(new int[]{p, q, color+1});
                        }
                    }
                }
            }
            distance++;
        }
        return distance;
    }

    private static void dfs(int[][] grid, int i, int j, int m, int n, Queue<int[]> queue) {
        // visit this cell, mark this cell to color 2
        grid[i][j] = 2;
        queue.offer(new int[]{i, j, 2});
        for (int k=0; k<4; k++) {
            int p = row[k] + i;
            int q = col[k] + j;
            if (isValid(p, q, m, n) && grid[i][j] == 1) {
                dfs(grid, p, q, m, n, queue);
            }
        }
    }

    private static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };
        System.out.println(shortestBridge(grid));
    }
}
