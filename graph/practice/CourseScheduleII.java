package graph.practice;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=0; i<numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        int n = prerequisites.length;
        for (int i=0; i<n; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Stack<Integer> order = new Stack<>();

        for (int i=0;i<numCourses;i++) {
            if (!visited[i]) {
                if (isCyclic(i, graph, visited, recStack, order)) {
                    return new int[0];
                }
            }
        }

        int[] ans = new int[numCourses];
        int i=0;
        while (!order.empty()) {
            ans[i++] = order.pop();
        }
        return ans;
    }

    private boolean isCyclic(int course, Map<Integer, Set<Integer>> graph, boolean[] visited, boolean[] recStack, Stack<Integer> order) {
        visited[course] = true;
        recStack[course] = true;
        Set<Integer> courses = graph.get(course);
        for (int c : courses) {
            if (recStack[c]) {
                return true;
            }
            if (!visited[c] && isCyclic(c, graph, visited, recStack, order)) {
                return true;
            }
        }
        recStack[course] = false;
        order.push(course);
        return false;
    }
}
