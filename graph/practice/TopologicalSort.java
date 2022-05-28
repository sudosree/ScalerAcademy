package graph.practice;

import java.util.*;

public class TopologicalSort {

    /**
     * TC = O(V+E), SC = O(V)
     * @param A
     * @param B
     * @return
     */
    private static List<Integer> findTopologicalSortUsingIndegree(int A, int[][] B) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=0;i<A;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            graph.get(u).add(v);
        }
        int[] indegree = new int[A];
        // find the indegree of all vertices
        for (int u : graph.keySet()) {
            Set<Integer> neighbors = graph.get(u);
            for (int v : neighbors) {
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        // add all the vertices with indegree 0 to the queue
        for (int i=0;i<A;i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans.add(u);
            Set<Integer> neighbors = graph.get(u);
            for (int v : neighbors) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return ans;
    }

    /**
     * TC = O(V+E), SC = O(V)
     * @param A
     * @param B
     * @return
     */
    private static List<Integer> topologicalSortUsingDFS(int A, int[][] B) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=0;i<A;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            graph.get(u).add(v);
        }
        boolean[] visited = new boolean[A+1];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<A;i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, stack);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    private static void dfs(int u, Map<Integer, Set<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        Set<Integer> neighbors = graph.get(u);
        for (int v : neighbors) {
            if (!visited[v]) {
                dfs(v, graph, visited, stack);
            }
        }
        stack.push(u);
    }

    private static List<Integer> topologicalSort(int[][] nums, int n) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // no. of vertices
        for (int i=0; i<n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0; i<nums.length; i++) {
            int u = nums[i][0];
            int v = nums[i][1];
            graph.get(u).add(v);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    private static void dfs(Map<Integer, Set<Integer>> graph, int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        Set<Integer> neighbors = graph.get(u);
        for (int v : neighbors) {
            if (!visited[v]) {
                dfs(graph, v, visited, stack);
            }
        }
        stack.push(u);
    }

    public static void main(String[] args) {
        int A = 6;
        int[][] B = {
                {5,0},
                {5,2},
                {4,0},
                {4,1},
                {2,3},
                {3,1},
        };
        System.out.println(findTopologicalSortUsingIndegree(A, B));
        System.out.println(topologicalSortUsingDFS(A, B));
        System.out.println(topologicalSort(B, A));
    }
}
