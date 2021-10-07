package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {

    class UnionFind {
        private int[] parent;
        private int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return false;
            }
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rooty] > rank[rootx]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx] += 1;
            }
            return true;
        }

        public int[] getParent() {
            return parent;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int i=0; i<edges.length; i++) {
            int[] e = edges[i];
            boolean valid = uf.union(e[0], e[1]);
            if (!valid) {
                return false;
            }
        }
        int[] parent = uf.getParent();
        int root = parent[0];
        for (int i=1; i<n; i++) {
            int x = i;
            while (parent[x] != x) {
                x = parent[x];
            }
            if (x != root) {
                return false;
            }
        }
        return true;
    }

    public boolean validTree1(int n, int[][] edges) {
        // we need to check two conditions -
        // 1. the graph should be fully connected i.e. starting from the 1st vertex
        // every other vertices should be connected
        // 2. there should not be any cycle present in the graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // to keep track of the visited vertices
        Set<Integer> visited = new HashSet<>();
        // if there are no cycles and all the vertices are visited starting from the
        // first vertex then it is a valid tree
        return !cycle(graph, 0, -1, visited) && visited.size() == n;
    }

    private boolean cycle(Map<Integer, Set<Integer>> graph, int u, int parent, Set<Integer> visited) {
        // visit this vertex
        visited.add(u);
        Set<Integer> neighbors = graph.get(u);
        for (int v : neighbors) {
            if (visited.contains(v) && v != parent) {
                return true;
            }
            if (!visited.contains(v)) {
                if (cycle(graph, v, u, visited)) {
                    return true;
                }
            }
        }
        // no cycle present
        return false;
    }
}
