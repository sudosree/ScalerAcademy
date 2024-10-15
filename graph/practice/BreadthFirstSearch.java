package graph.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

  public static List<String> breadthFirstSearch(List<List<String>> edges, String start) {
    Map<String, Set<String>> graph = new HashMap<>();
    for (List<String> edge : edges) {
      String u = edge.get(0);
      String v = edge.get(1);
      if (!graph.containsKey(u)) {
        graph.put(u, new HashSet<>());
      }
      graph.get(u).add(v);
    }
    List<String> ans = new ArrayList<>();
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    visited.add(start);
    while (!queue.isEmpty()) {
      String curr = queue.poll();
      ans.add(curr);
      Set<String> neighbors = graph.get(curr);
      for (String v : neighbors) {
        if (!visited.contains(v)) {
          queue.offer(v);
          visited.add(v);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
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

    System.out.println(breadthFirstSearch(edges, "A"));
  }
}
