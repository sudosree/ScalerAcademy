package graph.assignment;

import java.util.Arrays;
import java.util.Comparator;

public class CommutableIsland {

    static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[2] == o2[2]) {
                return 0;
            }
            return o1[2] < o2[2] ? -1 : 1;
        }
    }

    static class DSU {
        private static int[] parent;
        private static int[] height;

        private static void createSet(int A) {
            parent = new int[A+1];
            height = new int[A+1];
            for (int i=1;i<=A;i++) {
                parent[i] = i;
                height[i] = 0;
            }
        }

        private static int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        private static boolean union(int x, int y) {
            int u = find(x);
            int v = find(y);
            if (u == v) {
                return false;
            }
            if (height[u] < height[v]) {
                parent[u] = v;
            } else if (height[v] < height[u]) {
                parent[v] = u;
            } else {
                parent[u] = v;
                height[v]++;
            }
            return true;
        }
    }

    public int solve(int A, int[][] B) {
        DSU.createSet(A);
        Arrays.sort(B, new MyComparator());
        int cost = 0;
        for (int i=0;i<B.length;i++) {
            int[] edge = B[i];
            int parentX = DSU.find(edge[0]);
            int parentY = DSU.find(edge[1]);
            if (parentX == parentY) {
                continue;
            }
            DSU.union(edge[0], edge[1]);
            cost += edge[2];
        }
        return cost;
    }
}
