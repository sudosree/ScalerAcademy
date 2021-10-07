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

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        // there are two types of color 0 and 1, 1 for red and 0 for blue
        // initially all the nodes are marked with -1 i.e. no color
        Arrays.fill(colors, -1);
        for (int i=0; i<n; i++) {
            // not yet visited
            if (colors[i] == -1) {
                boolean bipartite = bfs(graph, i, colors);
                if (!bipartite) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int u, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        colors[u] = 1;   // red color
        while (!queue.isEmpty()) {
            u = queue.poll();
            int c = colors[u];
            int[] neighbors = graph[u];
            for (int v : neighbors) {
                // not yet visited
                if (colors[v] == -1) {
                    if (c == 1) {
                        colors[v] = 0;
                    } else {
                        colors[v] = 1;
                    }
                    queue.offer(v);
                }
                // if the colors are same
                else if (c == colors[v]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int u, int[] colors, int color) {
        colors[u] = color;
        int[] neighbors = graph[u];
        for (int v : neighbors) {
            if (colors[v] == -1) {
                if (!dfs(graph, v, colors, colors[u] ^ 1)) {
                    return false;
                }
            } else if (colors[v] == colors[u]) {
                return false;
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
