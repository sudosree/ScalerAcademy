package graph.practice;

import java.util.*;

public class AllPathsFromSourceToTargetDirectedGraph {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, path, ans, 0, graph.length-1);
        return ans;
    }

    private static void dfs(int[][] graph, List<Integer> path, List<List<Integer>> ans, int curr, int target) {
        if (curr == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        int[] neighbors = graph[curr];
        for (int v : neighbors) {
            path.add(v);
            dfs(graph, path, ans, v, target);
            path.remove(path.size()-1);
        }
    }

    public static List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        if (graph.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(path);

        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            int curr = list.get(list.size()-1);
            // if the current node is the last node then we have reached the end of the path
            // we don't need to go down from this path anymore
            if (curr == graph.length-1) {
                ans.add(list);
            } else {
                int[] neighbors = graph[curr];
                for (int v : neighbors) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(v);
                    queue.offer(temp);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        };
        System.out.println(allPathsSourceTarget(graph));
    }
}
