package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int n = prerequisites.length;
        for (int i=0;i<numCourses;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<n;i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            graph.get(u).add(v);
        }
        // to keep track of the recursive path
        boolean[] recStack = new boolean[numCourses];
        // to keep track of the nodes which are already checked i.e. not forming any cycle
        boolean[] visited = new boolean[numCourses];
        for (int i=0;i<numCourses;i++) {
            if (!visited[i] && isCyclic1(i, graph, visited, recStack)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCyclic(int u, Map<Integer, Set<Integer>> graph, boolean[] recStack, boolean[] checked) {


        if (checked[u]) {
            return false;
        }

        // back edge is present, you encounter a previously visited node
        if (recStack[u]) {
            return true;
        }
        // no following courses are present
        if (!graph.containsKey(u)) {
            return false;
        }
        recStack[u] = true;
        Set<Integer> courses = graph.get(u);
        for (int v : courses) {
            if (isCyclic(v, graph, recStack, checked)) {
                return true;
            }
        }
        // remove from the recursion stack
        recStack[u] = false;
        // completed the check of this node
        checked[u] = true;
        return false;
    }

    private static boolean isCyclic1(int src, Map<Integer, Set<Integer>> graph, boolean[] visited, boolean[] recStack) {
        visited[src] = true;
        recStack[src] = true;
        Set<Integer> nodes = graph.get(src);
        for (int v : nodes) {
            if (!visited[v] && isCyclic1(v, graph, visited, recStack)) {
                return true;
            } else if (recStack[v]) {
                return true;
            }
        }
        recStack[src] = false;
        return false;
    }

    public static void main(String[] args) {
        int numCourses= 2;
        int[][] prerequisites = {
                {0,1},
        };

        System.out.println(canFinish(numCourses, prerequisites));
    }
}
