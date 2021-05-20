package graph.practice;

import java.util.*;

public class BipartitieGraph {

    enum Color {
        RED, BLUE;
    };

    /**
     * TC = O(V+E)
     * @param A
     * @param B
     * @return
     */
    private static boolean checkBipartiteGraph(int A, int[][] B) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=1;i<=A;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[A+1];
        Color[] colors = new Color[A+1];
        for (int i=1;i<=A;i++) {
            if (!visited[i]) {
                boolean check = bfs(i, graph, visited, colors);
                if (!check) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(int src, Map<Integer, Set<Integer>> graph, boolean[] visited, Color[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited[src] = true;
        colors[src] = Color.RED;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            Color color;
            if (colors[u] == Color.RED) {
                color = Color.BLUE;
            } else {
                color = Color.RED;
            }
            Set<Integer> neighbors = graph.get(u);
            for (int v : neighbors) {
                if (!visited[v]) {
                    visited[v] = true;
                    colors[v] = color;
                    queue.offer(v);
                } else if (visited[v] && colors[v] == colors[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int A = 4;
        int[][] B = {
                {1,2},
                {1,4},
                {2,3},
                {3,4},
        };
        System.out.println(checkBipartiteGraph(A,B));
    }
}
