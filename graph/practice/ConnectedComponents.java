package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConnectedComponents {

    private static int find(int A, int[][] B) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[A+1];
        for (int i=1;i<=A;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return findConnectedComponents(graph, visited);
    }

    /**
     * TC = O(V+E), SC = O(V)
     * @param graph
     * @param visited
     * @return
     */
    private static int findConnectedComponents(Map<Integer, Set<Integer>> graph, boolean[] visited) {
        int count = 0;
        for (int u : graph.keySet()) {
            if (!visited[u]) {
                dfs(u, graph, visited);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int src, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        visited[src] = true;
        Set<Integer> neighbors = graph.get(src);
        for (int v : neighbors) {
            if (!visited[v]) {
                dfs(v, graph, visited);
            }
        }
    }

    int count;

    class UnionFind {
        private int[] parent;
        private int[] height;

        UnionFind(int n) {
            count = n;
            parent = new int[n];
            height = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
                height[i] = 1;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (height[rootx] > height[rooty]) {
                    parent[rooty] = rootx;
                } else if (height[rooty] > height[rootx]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    height[rootx] += 1;
                }
                count--;
            }
        }
    }

    /**
     * TC = O(E), SC = O(V)
     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return count;
    }

    public static void main(String[] args) {
        int A = 6;
        int[][] B = {
                {1,2},
                {1,3},
                {2,3},
                {4,5}
        };
        System.out.println(find(A, B));
    }
}
