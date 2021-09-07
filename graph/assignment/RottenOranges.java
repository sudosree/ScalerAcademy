package graph.assignment;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
        Pair pair;
        int level;
        Node(Pair pair, int level) {
            this.pair = pair;
            this.level = level;
        }
    }

    /**
     * TC = O(n * m), SC = O(N)
     */
    private static int solve(int[][] A) {
        int n = A.length, m = A[0].length;
        Queue<Node> queue = new LinkedList<>();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (A[i][j] == 2) {
                    Node node = new Node(new Pair(i, j), 0);
                    queue.offer(node);

                }
            }
        }
        int time = bfs(A, queue, n, m);
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (A[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    private static int bfs(int[][] A, Queue<Node> queue, int n, int m) {
        int[] row = {-1, 0, 0, 1};
        int[] col = {0, -1, 1, 0};
        int time = 0;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            time = tmp.level;
            int i = tmp.pair.x;
            int j = tmp.pair.y;
            for (int k=0;k<4;k++) {
                int p = i+row[k];
                int q = j+col[k];
                if (isValid(p, n) && isValid(q,m) && A[p][q] == 1) {
                    A[p][q] = 2;
                    queue.offer(new Node(new Pair(p, q), tmp.level +1));
                }
            }
        }
        return time;
    }

    private static boolean isValid(int i, int n) {
        return i >= 0 && i < n;
    }

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        // first add all the rotten oranges to the queue
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        // if there are no fresh oranges then return 0
        if (freshOranges == 0) {
            return 0;
        }
        int[] row = {-1, 0, 0, 1};
        int[] col = {0, -1, 1, 0};
        int time = 0;
        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];
                for (int k=0; k<4; k++) {
                    int p = r + row[k];
                    int q = c + col[k];
                    if (isValid(p, q, m, n) && grid[p][q] == 1) {
                        grid[p][q] = 2;
                        queue.offer(new int[]{p, q});
                        freshOranges--;
                    }
                }
            }
        }
        return freshOranges == 0 ? time - 1 : -1;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        int[][] A = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(solve(A));
    }
}
