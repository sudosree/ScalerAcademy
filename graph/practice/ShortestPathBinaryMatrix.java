package graph.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // if the top left element is 1 or the bottom right element is 1
        // then we cannot reach the destination
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            int dist = grid[i][j];
            if (i == n-1 && j == n-1) {
                return dist;
            }
            for (int k=0;k<8;k++) {
                int p = i + row[k];
                int q = j + col[k];
                if (isValid(p, q, n) && grid[p][q] == 0) {
                    grid[p][q] = dist+1;
                    queue.offer(new int[]{p,q});
                }
            }
        }
        return -1;
    }

    public static int shortestPathBinaryMatrix1(int[][] grid) {
        int n = grid.length;
        // if the top left element is 1 or the bottom right element is 1
        // then we cannot reach the destination
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();
        // put distances in the queue
        queue.offer(new int[]{0, 0, 1});

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int dist = cell[2];
            if (r == n-1 && c == n-1) {
                return dist;
            }
            for (int k=0;k<8;k++) {
                int p = r + row[k];
                int q = c + col[k];
                if (isValid(p, q, n) && grid[p][q] == 0 && !visited[p][q]) {
                    visited[p][q] = true;
                    queue.offer(new int[]{p, q, dist+1});
                }
            }
        }
        return -1;
    }

    public static int shortestPathBinaryMatrix2(int[][] grid) {
        int n = grid.length;
        // if the top left element is 1 or the bottom right element is 1
        // then we cannot reach the destination
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();
        // put distances in the queue
        queue.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                if (r == n-1 && c == n-1) {
                    return distance;
                }
                for (int k=0;k<8;k++) {
                    int p = r + row[k];
                    int q = c + col[k];
                    if (isValid(p, q, n) && grid[p][q] == 0 && !visited[p][q]) {
                        visited[p][q] = true;
                        queue.offer(new int[]{p, q});
                    }
                }
            }
            // process all the nodes at distance + 1
            distance++;
        }
        return -1;
    }

    public static int shortestPathBinaryMatrix3(int[][] grid) {
        int n = grid.length;
        // if the first cell is blocked or the last cell is blocked
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        int count = 0;
        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        // mark the cell as visited so that you do not visit it again
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pair = queue.poll();
                for (int k=0; k<8; k++) {
                    int p = row[k] + pair[0];
                    int q = col[k] + pair[1];
                    if (isValid(p, q, n) && grid[p][q] == 0) {
                        queue.offer(new int[]{p, q});
                        grid[p][q] = 1;
                    }
                }
            }
            count++;
        }
        return count;
    }

    private static boolean isValid(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0},
                {1,0,1,0},
                {1,1,0,1},
                {0,0,0,0}
        };
        System.out.println(shortestPathBinaryMatrix3(grid));
    }
}
