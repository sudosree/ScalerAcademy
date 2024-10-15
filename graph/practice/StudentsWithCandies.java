package graph.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentsWithCandies {

  public static int maxStudentsWithCandies(int students, int friendship, int C, int[][] pairs, int[] candies) {
    // 1. create a student friendship graph
    // 2. find the no. of connected components i.e. a set of students that are directly or indirectly connected
    // 3. each connected component can take all the candies if the total no. of candies taken by all the students is less than
    // or equal to the available candies C
    // 4. connected component cannot take all the candies if the total no. of candies taken by all the students is more than
    // the available candies C
    // 5. add the no. of students from each connected component (if the component can take all the candies) to the result

    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i=1; i<=students; i++) {
      graph.put(i, new HashSet<>());
    }

    for (int i=0; i<friendship; i++) {
      int u = pairs[0][0];
      int v = pairs[0][1];
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    boolean[] visited = new boolean[students];
    List<List<Integer>> components = new ArrayList<>();

    for (int i=0; i<students; i++) {
      if (!visited[i]) {
        List<Integer> component = new ArrayList<>();
        findConnectedComponent(i, graph, visited, component);
        components.add(component);
      }
    }

    int maxStudents = 0;
    // for each group of friends check if a group can take candies s.t it is less than or equal to the available candy
    for (List<Integer> c : components) {
      int totalCandies = 0;
      for (int student : c) {
        totalCandies += candies[student-1];
      }
      if (totalCandies <= C) {
        maxStudents += c.size();
      }
    }
    return maxStudents;
  }


  private static void findConnectedComponent(int student, Map<Integer, Set<Integer>> graph, boolean[] visited, List<Integer> component) {
    visited[student] = true;
    component.add(student+1);
    // check its neighbors
    Set<Integer> neighbors = graph.get(student+1);
    for (int v : neighbors) {
      if (!visited[v]) {
        findConnectedComponent(v, graph, visited, component);
      }
    }
  }

  public static void main(String[] args) {
    int students = 5;
    int friendship = 2;
    int C = 10;
    int[][] pairs = {
        {1,2}, {2,3}
    };
    int[] candies = {3, 5, 2, 4, 6};
    System.out.println(maxStudentsWithCandies(students, friendship, C, pairs, candies));
  }
}
