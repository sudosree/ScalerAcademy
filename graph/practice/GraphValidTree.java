package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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

    private boolean hasCycle(int node, int parent, Set<Integer> visited, Map<Integer, Set<Integer>> graph) {

        // visit the node
        visited.add(node);

        // if the node u is already visited and the parent of u is not equal to v
        // then node u has already been reached before by some other node and that node
        // is the parent node of node u
        Set<Integer> neighbors = graph.get(node);
        for (int neighbor : neighbors) {
            // if the neighbor is already visited and it's not the parent
            // of the current node then there is a cycle
            if (visited.contains(neighbor) && neighbor != parent) {
                return true;
            }
            if (!visited.contains(neighbor)) {
                if (hasCycle(neighbor, node, visited, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validTree2(int n, int[][] edges) {
        int m = edges.length;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0; i<m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        parent.put(0,-1);
        visited.add(0);

        while (!stack.empty()) {
            int node = stack.pop();
            Set<Integer> neighbors = graph.get(node);
            for (int neighbor : neighbors) {
                // there is a cycle, so it cannot be a valid tree
                if (visited.contains(neighbor) && parent.get(node) != neighbor) {
                    return false;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, node);
                    stack.push(neighbor);
                }
            }
        }
        return visited.size() == n;
    }
}
