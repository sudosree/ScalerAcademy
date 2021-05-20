package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CycleInUndirectedGraphUsingDSU {

    private static int[] parent;
    private static int[] height;

    private static boolean hasCycle(int A, int[][] B) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=1;i<=A;i++) {
            graph.put(i, new HashSet<>());
            parent[i] = i;
            height[i] = 0;
        }
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            graph.get(u).add(v);
        }

        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            if (!union(u, v)) {
                return false;
            }
        }
        return true;
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
