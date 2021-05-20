package graph.assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CycleInDirectedGraph {

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
        boolean[] recStack = new boolean[A+1];
        for (int i=1;i<=A;i++) {
            if (!visited[i]) {
                if (isCyclic(i, graph, visited, recStack)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static boolean isCyclic(int src, Map<Integer, Set<Integer>> graph, boolean[] visited, boolean[] recStack) {
        visited[src] = true;
        recStack[src] = true;
        Set<Integer> nodes = graph.get(src);
        for (int v : nodes) {
            if (!visited[v] && isCyclic(v, graph, visited, recStack)) {
                return true;
            } else if (recStack[v]) {
                return true;
            }
        }
        recStack[src] = false;
        return false;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {
                {1,2},
                {2,3},
                {3,4},
                {4,5},
        };
        System.out.println(solve(A,B));
    }
}
