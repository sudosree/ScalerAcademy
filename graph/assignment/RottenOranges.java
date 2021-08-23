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

    public static void main(String[] args) {
        int[][] A = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(solve(A));
    }
}
