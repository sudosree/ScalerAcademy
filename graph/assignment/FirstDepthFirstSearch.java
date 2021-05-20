package graph.assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstDepthFirstSearch {

    public static int solve(int[] A, final int B, final int C) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[A.length+1];
        for (int i=1;i<A.length;i++) {
            graph.put(A[i], new HashSet<>());
        }
        for (int i=1;i<A.length;i++) {
            graph.get(A[i]).add(i+1);
        }
        dfs(C, graph, visited);
        return visited[B] ? 1 : 0;
    }

    /**
     * TC = O(V+E), SC = O(V)
     * @param src
     * @param graph
     * @param visited
     */
    private static void dfs(int src, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        visited[src] = true;
        if (graph.containsKey(src)) {
            Set<Integer> nodes = graph.get(src);
            for (int v : nodes) {
                if (!visited[v]) {
                    dfs(v, graph, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 3, 3, 2, 2, 7, 6};
        int B = 2, C = 8;
        System.out.println(solve(A,B,C));
    }
}
