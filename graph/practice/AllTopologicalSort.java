package graph.practice;

import java.util.*;

public class AllTopologicalSort {

    private static List<List<Integer>> findAllTopologicalOrders(int[][] nums, int courses) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=0; i<courses; i++) {
            graph.put(i, new HashSet<>());
        }
        int[] indegree = new int[courses];
        for (int i=0; i< nums.length; i++) {
            int u = nums[i][0];
            int v = nums[i][1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<courses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        printAllTopologicalSort(graph, queue, indegree, list, ans);
        return ans;
    }

    private static void printAllTopologicalSort(Map<Integer, Set<Integer>> graph, Queue<Integer> queue,
                                                int[] indegree, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == indegree.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int source : queue) {
            list.add(source);
            Queue<Integer> sourcesForNextCall = cloneQueue(queue);
            int u = sourcesForNextCall.poll();
            Set<Integer> neighbors = graph.get(u);
            for (int v : neighbors) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    sourcesForNextCall.offer(v);
                }
            }
            printAllTopologicalSort(graph, sourcesForNextCall, indegree, list, ans);
            list.remove(source);
            for (int v : neighbors) {
                indegree[v]++;
            }
        }
    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (int u : queue) {
            clone.offer(u);
        }
        return clone;
    }

    public static void main(String[] args) {
        int courses = 6;
        int[][] nums = {
                {5,0},
                {4,0},
                {5,2},
                {4,1},
                {2,3},
                {3,1}
        };
        System.out.println(findAllTopologicalOrders(nums, courses));
    }
}
