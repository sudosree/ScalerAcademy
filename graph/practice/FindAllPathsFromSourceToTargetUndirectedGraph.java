package graph.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllPathsFromSourceToTargetUndirectedGraph {

  public static List<List<String>> findAllPaths(List<List<String>> edges, String source, String target) {
    Map<String, Set<String>> graph = new HashMap<>();
    for (List<String> edge : edges) {
      String u = edge.get(0);
      String v = edge.get(1);
      if (!graph.containsKey(u)) {
        graph.put(u, new HashSet<>());
      }
      graph.get(u).add(v);
    }
    Set<String> visited = new HashSet<>();
    List<String> path = new ArrayList<>();
    List<List<String>> allPaths = new ArrayList<>();
    findAllPathsHelper(source, target, graph, visited, path, allPaths);
    return allPaths;
  }

  private static void findAllPathsHelper(String curr, String target, Map<String, Set<String>> graph, Set<String> visited, List<String> path, List<List<String>> allPaths) {
    // visit the current node
    visited.add(curr);
    // add the current node to the current path
    path.add(curr);
    // if the curr node is the target node
    if (curr.equals(target)) {
      allPaths.add(new ArrayList<>(path));
      return;
    }
    // visit it's neighbors
    Set<String> neighbors = graph.get(curr);
    for (String v : neighbors) {
      if (!visited.contains(v)) {
        findAllPathsHelper(v, target, graph, visited, path, allPaths);
        // once the node is visited the unmark it and remove it from the current path
        visited.remove(v);
        path.remove(path.size()-1);
      }
    }
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
    String source = "A", target = "B";
    System.out.println(findAllPaths(edges, source, target));
  }
}
