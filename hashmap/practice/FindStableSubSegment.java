package hashmap.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindStableSubSegment {

  private static int findStableSubSegment(int n, int[] capacity) {
    if (capacity.length < 3) {
      return 0;
    }
    int count = 0;
    int[] prefixSum = new int[n];
    prefixSum[0] = capacity[0];
    for (int i=1; i<n; i++) {
      prefixSum[i] = prefixSum[i-1] + capacity[i];
    }
    for (int l=0; l<n-2; l++) {
      for (int r=l+2; r<n; r++) {
        // no need to check the sum of the capacity of the internal servers
        if (capacity[l] != capacity[r]) {
          continue;
        }
        // else check the sum of the capacity of the internal servers
        int internalServersSum = prefixSum[r] - prefixSum[l] - capacity[r];
        if (internalServersSum == capacity[l]) {
          count++;
        }
      }
    }
    return count;
  }

  private static int findStableSubSegment1(int n, int[] capacity) {
    if (capacity.length < 3) {
      return 0;
    }
    int count = 0;
    int[] prefixSum = new int[n];
    prefixSum[0] = capacity[0];
    for (int i=1; i<n; i++) {
      prefixSum[i] = prefixSum[i-1] + capacity[i];
    }

    Map<Integer, List<Integer>> capacityToIndicesMapping = new HashMap<>();
    addIndexToCapacityIndicesMap(capacityToIndicesMapping, capacity[0], 0);
//    capacityToIndicesMapping.put(capacity[0], Arrays.asList(0));

    for (int i=1; i<n; i++) {
      List<Integer> indices = capacityToIndicesMapping.getOrDefault(capacity[i], new ArrayList<>());
      for (int j : indices) {
        // check if the length of the current segment is >= 3
        if (i - j >= 2) {
          if (capacity[i] == (prefixSum[i-1] - prefixSum[j])) {
            count++;
          }
        }
      }
//      indices.add(i);
      // add the current index to the list of for the current capacity
      addIndexToCapacityIndicesMap(capacityToIndicesMapping, capacity[i], i);
//      capacityToIndicesMapping.put(capacity[i], indices);
    }
    return count;
  }

  private static void addIndexToCapacityIndicesMap(Map<Integer, List<Integer>> capacityToIndicesMapping, int capacity, int index) {
    List<Integer> indices = capacityToIndicesMapping.getOrDefault(capacity, new ArrayList<>());
    indices.add(index);
    capacityToIndicesMapping.put(capacity, indices);
  }

  public static void main(String[] args) {
    int n = 5;
    int[] capacity = {9,3,3,3,9};
    System.out.println(findStableSubSegment(n, capacity));
    System.out.println(findStableSubSegment1(n, capacity));
  }
}
