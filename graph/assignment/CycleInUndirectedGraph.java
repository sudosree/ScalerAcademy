package graph.assignment;

import java.util.*;

public class CycleInUndirectedGraph {

    static class Pair {
        int src;
        int parent;
        Pair(int src, int parent) {
            this.src = src;
            this.parent = parent;
        }
    }

    public static int solve(int A, int[][] B) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=1;i<=A;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            graph.get(u).add(v);
        }
        boolean[] visited = new boolean[A+1];
        for (int i=1;i<=A;i++) {
            if (!visited[i]) {
                if (isCyclic(i, -1, graph, visited)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static boolean isCyclic(int u, int parent, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        visited[u] = true;
        Set<Integer> nodes = graph.get(u);
        for (int v : nodes) {
            if (visited[v] && v != parent) {
                return true;
            }
            if (!visited[v]) {
                if (isCyclic(v, u, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclic1(int src, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        visited[src] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(src, -1));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Set<Integer> nodes = graph.get(p.src);
            for (int v : nodes) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(new Pair(v, p.src));
                } else if (v != p.parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {
                {1,2},
                {1,3},
                {2,3},
                {1,4},
                {4,5},
        };
        System.out.println(solve(A,B));
    }
}
