package graph.homework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {

    static class Node {
        int vertex1;
        int vertex2;

        Node(int vertex1, int vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }
    }

    static class Pair {
        Node node;
        int dist;

        Pair(Node node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    /**
     * TC = O(n * m)
     * @param A
     */
    public static void solve(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<Pair> queue = new LinkedList<>();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (A[i][j] == 1) {
                    queue.offer(new Pair(new Node(i,j), 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] row = {-1, 0, 0, 1};
        int[] col = {0, -1, 1, 0};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            int v1 = node.vertex1;
            int v2 = node.vertex2;
            int d = pair.dist;
            ans[v1][v2] = d;

            for (int k=0;k<4;k++) {
                int i = v1 + row[k];
                int j = v2 + col[k];
                if (isValid(i, n) && isValid(j, m) && A[i][j] == 0 && !visited[i][j]) {
                    queue.offer(new Pair(new Node(i, j), d+1));
                    visited[i][j] = true;
                }
            }
        }
//        return ans;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int i, int n) {
        return i >= 0 && i < n;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0},
        };
        solve(A);
    }
}
