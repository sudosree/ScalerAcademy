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

    public static void dfs1(List<List<String>> edges, String start) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> edge : edges) {
            String u = edge.get(0);
            String v = edge.get(1);
            if (!graph.containsKey(u)) {
                graph.put(u, new HashSet<>());
            }
            graph.get(u).add(v);
        }
        Set<String> visited = new HashSet<>();
        dfsR(graph, visited, start);
    }

    private static void dfsR(Map<String, Set<String>> graph, Set<String> visited, String u) {
        // visit the node
        visited.add(u);
        System.out.print(u + " ");
        // visit it's neighbors
        Set<String> neighbors = graph.get(u);
        for (String v : neighbors) {
            // if the node is not visited then visit it
            if (!visited.contains(v)) {
                dfsR(graph, visited, v);
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

        List<List<String>> edges = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("A", "D"),
            Arrays.asList("A", "C"),
            Arrays.asList("B", "A"),
            Arrays.asList("B", "E"),
            Arrays.asList("B", "F"),
            Arrays.asList("F", "B"),
            Arrays.asList("F", "E"),
            Arrays.asList("E", "F"),
            Arrays.asList("E", "B"),
            Arrays.asList("E", "D"),
            Arrays.asList("E", "C"),
            Arrays.asList("C", "A"),
            Arrays.asList("C", "E"),
            Arrays.asList("D", "A"),
            Arrays.asList("D", "E")
        );

        dfs1(edges, "A");

    }
}
