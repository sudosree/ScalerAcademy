package graph.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindShortestPath {

  public static List<String> findShortestPath(List<List<String>> edges, String source, String destination) {
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
    Queue<List<String>> queue = new LinkedList<>();
    queue.offer(Collections.singletonList(source));
    visited.add(source);
    while (!queue.isEmpty()) {
      List<String> currPath = queue.poll();
      String curr = currPath.get(currPath.size()-1);
      // check if the last element is the destination then you found the shortest path
      if (curr.equals(destination)) {
        return currPath;
      }
      Set<String> neighbors = graph.get(curr);
      for (String v : neighbors) {
        if (!visited.contains(v)) {
          List<String> newPath = new ArrayList<>(currPath);
          newPath.add(v);
          queue.offer(newPath);
          visited.add(v);
        }
      }
    }
    return new ArrayList<>();
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

    System.out.println(findShortestPath(edges, "A", "F"));
  }

}
