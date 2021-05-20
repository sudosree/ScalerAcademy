package graph.assignment;

import java.util.*;

public class EdgeInMST {

    /*static class DisjointSetUnion {

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
    }*/

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

    static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[2] == o2[2]) {
                return 0;
            }
            return o1[2] < o2[2] ? -1 : 1;
        }
    }

    private static int[] solve(int A, int[][] B) {
        createSet(A);
        Map<int[], Integer> edgeIndexMap = new HashMap<>();
        Map<Integer, int[]> indexEdgeMap = new HashMap<>();

        for (int i=0;i<B.length;i++) {
            edgeIndexMap.put(B[i], i);
            indexEdgeMap.put(i, B[i]);
        }
        Arrays.sort(B, new MyComparator());

        int[] result = new int[B.length];
        int minCost = 0;
        for (int i=0;i<B.length;i++) {
            int[] edge = B[i];
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int parent_u = find(u);
            int parent_v = find(v);
            int j = edgeIndexMap.get(edge);
            if (parent_u == parent_v) {
                result[j] = 0;
            } else {
                result[j] = 1;
                if (height[parent_u] < height[parent_v]) {
                    parent[parent_u] = parent_v;
                } else if (height[parent_v] < height[parent_u]) {
                    parent[parent_v] = parent_u;
                } else {
                    parent[parent_u] = parent_v;
                    height[parent_v]++;
                }
                minCost += w;
            }
        }
        for (int i=0;i<result.length;i++) {
            if (result[i] == 0) {
                int[] edge = indexEdgeMap.get(i);
                int cost = edge[2];
                createSet(A);
                parent[edge[1]] = edge[0];
                for (int j=0;j<B.length;j++) {
                    int parent_u = find(B[j][0]);
                    int parent_v = find(B[j][1]);
                    if (parent_u == parent_v) {
                        continue;
                    }
                    if (height[parent_u] < height[parent_v]) {
                        parent[parent_u] = parent_v;
                    } else if (height[parent_v] < height[parent_u]) {
                        parent[parent_v] = parent_u;
                    } else {
                        parent[parent_u] = parent_v;
                        height[parent_v]++;
                    }
                    cost += B[j][2];
                    if (cost > minCost) {
                        break;
                    }
                }
                if (cost == minCost) {
                    result[i] = 1;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        /*int A = 6;
        int[][] B = {
                {1, 2, 7},
                {2, 3, 3},
                {3, 4, 5},
                {4, 5, 5},
                {1, 6, 8},
                {6, 5, 3},
                {2, 6, 3},
                {3, 5, 3},
                {3, 6, 4},
        };*/
        int A = 6;
        int[][] B = {
                {1, 2, 1},
                {2, 3, 1},
                {3, 4, 1},
                {4, 1, 1},
                {4, 5, 2},
                {3, 5, 2},
                {1, 6, 2},
                {2, 6, 2},
        };
        System.out.println(Arrays.toString(solve(A,B)));
    }
}
