package graph.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindNearestAncestor {

  private static List<Integer> findNearestAncestors(int[][] parentChild, int node) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i=0; i<parentChild.length; i++) {
      int p = parentChild[i][0];
      int c = parentChild[i][1];
      if (!graph.containsKey(c)) {
        graph.put(c, new HashSet<>());
      }
      graph.get(c).add(p);
    }
    // if the node doesn't have any parents then it cannot have any ancestors
    if (!graph.containsKey(node)) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    int minDist = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{node, 0});
    while (!queue.isEmpty()) {
      int[] pair = queue.poll();
      int currNode = pair[0];
      int currDist = pair[1];
      // currNode is an ancestor node and also check if it is the nearest ancestor node or not
      if (!graph.containsKey(currNode) && (minDist == 0 || minDist == currDist)) {
        minDist = currDist;
        ans.add(currNode);
        continue;
      }
      // if the curr node is not an ancestor
      if (graph.containsKey(currNode)) {
        Set<Integer> parents = graph.get(currNode);
        for (int p : parents) {
          queue.offer(new int[]{p, currDist + 1});
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] parentChild = {
        {1,3}, {2,3}, {3,6}, {5,6}, {5,7}, {4,5},
        {4,8}, {8,9}, {10,2}
    };
    System.out.println(findNearestAncestors(parentChild, 6));
    System.out.println(findNearestAncestors(parentChild, 7));
    System.out.println(findNearestAncestors(parentChild, 8));
    System.out.println(findNearestAncestors(parentChild, 9));
  }
}
