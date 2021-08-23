package dynamicprogramming.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ExistsPath {

    private static boolean existsPath(int[][] grid) {
        // find the source and destination
        int sX = -1, sY = -1;
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                // source cell
                if (grid[i][j] == 1) {
                    sX = i;
                    sY = j;
                }
            }
            if (sX != -1 && sY != -1) {
                break;
            }
        }

//        return existsPathHelper(grid, sX, sY, n, m, visited);
        return bfs(grid, sX, sY, n, m, visited);
    }

    private static boolean existsPathHelper(int[][] grid, int i, int j, int n, int m, boolean[][] visited) {
        // reached destination
        if (isValid(i, n) && isValid(j, m) && grid[i][j] == 2) {
            return true;
        }
        if (isValid(i, n) && isValid(j, m) && grid[i][j] == 0) {
            return false;
        }
        // mark this cell as visited
        visited[i][j] = true;
        // explore all the possible moves
        // move up
        boolean moveUp = isValid(i-1, n) && !visited[i-1][j] && existsPathHelper(grid, i-1, j, n, m, visited);

        // move down
        boolean moveDown = isValid(i+1, n) && !visited[i+1][j] && existsPathHelper(grid, i+1, j, n, m, visited);

        // move left
        boolean moveLeft = isValid(j-1, m) && !visited[i][j-1] && existsPathHelper(grid, i, j-1, n, m, visited);

        // move right
        boolean moveRight = isValid(j+1, m) && !visited[i][j+1] && existsPathHelper(grid, i, j+1, n, m, visited);

        return moveUp || moveDown || moveLeft || moveRight;
    }

    private static boolean isValid(int i, int n) {
        return i >= 0 && i < n;
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean bfs(int[][] grid, int i, int j, int n, int m, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            i = p.x;
            j = p.y;

            // move up
            if (isValid(i-1, n)) {
                if (grid[i-1][j] == 3 && !visited[i-1][j]) {
                    queue.offer(new Pair(i-1, j));
                } else if (grid[i-1][j] == 2) {
                    return true;
                }
            }

            // move down
            if (isValid(i+1, n)) {
                if (grid[i+1][j] == 3 && !visited[i+1][j]) {
                    queue.offer(new Pair(i+1, j));
                } else if (grid[i+1][j] == 2) {
                    return true;
                }
            }

            // move left
            if (isValid(j-1, m)) {
                if (grid[i][j-1] == 3 && !visited[i][j-1]) {
                    queue.offer(new Pair(i, j-1));
                } else if (grid[i][j-1] == 2) {
                    return true;
                }
            }

            // move right
            if (isValid(j+1, m)) {
                if (grid[i][j+1] == 3 && !visited[i][j+1]) {
                    queue.offer(new Pair(i, j+1));
                } else if (grid[i][j+1] == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,3,1,0},
                {3,0,3,3},
                {2,3,0,3},
                {0,3,3,3},
        };

        System.out.println(existsPath(grid));
    }
}
