package hashmap.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumCost {

  private static int minimumCost(int numProjects, int[] projectId, int[] bid) {

    // create a map with projectId to its minimum bid
    Map<Integer, Integer> projectIdToMinBid = new HashMap<>();
    for (int i=0; i<projectId.length; i++) {
      int pId = projectId[i];
      if (!projectIdToMinBid.containsKey(pId)) {
        projectIdToMinBid.put(pId, bid[i]);
      } else {
        if (bid[i] < projectIdToMinBid.get(pId)) {
          projectIdToMinBid.put(pId, bid[i]);
        }
      }
    }
    int minCost = 0;
    for (int i=0; i<numProjects; i++) {
      if (projectIdToMinBid.containsKey(i)) {
        minCost += projectIdToMinBid.get(i);
      } else {
        return -1;
      }
    }
    return minCost;
  }

  public static void main(String[] args) {
    int numProjects = 3;
    int[] projectId = {0, 1, 0, 1, 1};
    int[] bid = {4, 74, 47, 744, 7};

    System.out.println(minimumCost(numProjects, projectId, bid));
  }
}
