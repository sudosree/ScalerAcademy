package graph.practice;

import java.util.*;

public class DepthFirstSearch {

    private static void dfs(int vertices, int[][] A) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[vertices+1];
        for (int i=1;i<=vertices;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<A.length;i++) {
            int u = A[i][0];
            int v = A[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfsR(1, graph, visited);
//        dfsHelper(1, graph, visited);
    }

    /**
     * TC = O(V+E), SC = O(V)
     */
    private static void dfsHelper(int src, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        visited[src] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            System.out.print(u + " ");
            Set<Integer> neighbors = graph.get(u);
            for (int v : neighbors) {
                if (!visited[v]) {
                    visited[v] = true;
                    stack.push(v);
                }
            }
        }
    }

    /**
     * TC = O(V+E), SC = O(V)
     */
    private static void dfsR(int src, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        System.out.print(src + " ");
        visited[src] = true;
        Set<Integer> neighbors = graph.get(src);
        for (int v : neighbors) {
            if (!visited[v]) {
                dfsR(v, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        int[][] A = {
                {1,2},
                {1,3},
                {2,4},
                {2,5}
        };
        dfs(vertices, A);
    }
}
