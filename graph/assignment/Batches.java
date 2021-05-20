package graph.assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Batches {

    static class DSU {
        private static int[] parent;
        private static int[] size;
        private static Map<Integer, Integer> strength;
        private static Map<Integer, Boolean> connected;

        private static void createSet(int A, int[] B) {
            parent = new int[A+1];
            size = new int[A+1];
            strength = new HashMap<>();
            connected = new HashMap<>();
            for (int i=1;i<=A;i++) {
                parent[i] = i;
                size[i] = 1;
            }
            for (int i=0;i<B.length;i++) {
                strength.put(i+1, B[i]);
                connected.put(i+1, false);
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
            if (size[u] < size[v]) {
                parent[u] = v;
                size[v] += size[u];
                strength.put(v, strength.get(v) + strength.get(u));
                connected.put(u, true);
            } else if (size[v] < size[u]) {
                parent[v] = u;
                size[u] += size[v];
                strength.put(u, strength.get(u) + strength.get(v));
                connected.put(v, true);
            } else {
                parent[u] = v;
                size[v] += size[u];
                strength.put(v, strength.get(v) + strength.get(u));
                connected.put(u, true);
            }
            return true;
        }
    }

    public int solve(int A, int[] B, int[][] C, int D) {
        DSU.createSet(A, B);
        for (int i=0;i<C.length;i++) {
            int u = C[i][0];
            int v = C[i][1];
            DSU.union(u, v);
        }
        int count = 0;
        Map<Integer, Integer> strength = DSU.strength;
        Map<Integer, Boolean> connected = DSU.connected;

        for (int i : strength.keySet()) {
            if (!connected.get(i) && strength.get(i) >= D) {
                count++;
            }
        }
        return count;
    }

    private static int sum = 0;

    public static int solve1(int A, int[] B, int[][] C, int D) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=1;i<=A;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<C.length;i++) {
            int u = C[i][0];
            int v = C[i][1];
            graph.get(u).add(v);
        }
        boolean[] visited = new boolean[A+1];
        int count = 0;
        for (int i=1;i<=A;i++) {
            // part of other connected component
            if (!visited[i]) {
                sum = 0;
                dfs(i, graph, visited, B);
                if (sum >= D) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int src, Map<Integer, Set<Integer>> graph, boolean[] visited, int[] B) {
        visited[src] = true;
        sum += B[src-1];
        Set<Integer> neighbors = graph.get(src);
        for (int v : neighbors) {
            if (!visited[v]) {
                dfs(v, graph, visited, B);
            }
        }
    }

    public static void main(String[] args) {
        int A = 7;
        int[] B = {1, 6, 7, 2, 9, 4, 5};
        int[][] C = {
                {1,2},
                {2,3},
                {5,6},
                {5,7},
        };
        int D = 12;
        System.out.println(solve1(A,B,C,D));
    }
}
