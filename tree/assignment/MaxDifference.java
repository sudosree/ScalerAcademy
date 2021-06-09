package tree.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxDifference {

    static class TreeNodeInfo {
        int min;
        int max;

        public TreeNodeInfo(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private static int maxDiff = Integer.MIN_VALUE;

    public static int solve(int[] A, int[][] B) {
        // create adjacency list
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i=1;i<A.length+1;i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        boolean[] visited = new boolean[A.length+1];
        findMaxDiff(1, A, edges, visited);
        return maxDiff;
    }

    private static TreeNodeInfo findMaxDiff(int root, int[] A, Map<Integer, List<Integer>> edgeMap, boolean[] visited) {
        TreeNodeInfo node = new TreeNodeInfo(A[root-1], A[root-1]);
        visited[root] = true;
        List<Integer> edges = edgeMap.get(root);
        int min = A[root-1], max = A[root-1];
        for (int c : edges) {
            if (!visited[c]) {
                TreeNodeInfo nodeInfo = findMaxDiff(c, A, edgeMap, visited);
                min = Math.min(min, nodeInfo.min);
                max = Math.max(max, nodeInfo.max);
            }
        }
        int currDiff = Math.max(A[root-1] - min, max - A[root-1]);
        maxDiff = Math.max(maxDiff, currDiff);
        min = Math.min(min, A[root-1]);
        max = Math.max(max, A[root-1]);
        return new TreeNodeInfo(min, max);
    }

    public static void main(String[] args) {
        int[] A = {-59, -33, 34, 0, 69, 24, -22, 58, 62, -36, 5, 45, -19};
        int[][] B = {
                {10,6},
                {3,2},
                {12,7},
                {9,5},
                {2,1},
                {8,3},
                {7,1},
                {4,2},
                {6,3},
                {11,4},
                {5,3},
                {13,11},
        };
        System.out.println(solve(A, B));
    }
}
