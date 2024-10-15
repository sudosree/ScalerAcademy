package greedy.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumEfficiency {

  private static long getMaximumEfficiency(int n, int k, int[] capacities, int[] numServers) {
    // sort the capacities in ascending order
    Arrays.sort(capacities);

    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    for (int capacity : capacities) {
      minHeap.offer(capacity);
      maxHeap.offer(capacity);
    }

    // create a list of batches
    List<List<Integer>> batches = new ArrayList<>();
    for (int i=0; i<k; i++) {
      batches.add(new ArrayList<>());
    }

    int[] batchSize = numServers.clone();
    Integer[] batchIds = new Integer[k];
    for (int i=0; i<k; i++) {
      batchIds[i] = i;
    }
    // sort the batch ids based on batch sizes in descending order
    Arrays.sort(batchIds, (a, b) -> batchSize[b] - batchSize[a]);

    for (int id : batchIds) {
      // get the size of a batch based on its id
      int size = batchSize[id];
      List<Integer> batch = batches.get(id);
      // assign the largest capacity to the current batch
      if (size > 0) {
        batch.add(maxHeap.poll());
        size--;
      }
      // assign the smallest capacity to the current batch
      if (size > 0) {
        batch.add(minHeap.poll());
        size--;
      }
      // assign the remaining capacities to the current batch
      while (size > 0) {
        batch.add(maxHeap.poll());
        size--;
      }
    }

    long totalEfficiencies = 0;
    for (List<Integer> batch : batches) {
      int min = Collections.min(batch);
      int max = Collections.max(batch);
      totalEfficiencies += (max - min);
    }
    return totalEfficiencies;
  }

  private static long getMaximumEfficiency1(int n, int k, int[] capacities, int[] numServers) {
    // keeps track of the no. of batches if the batch has no. of servers more than 1
    int batches = 0;
    for (int servers : numServers) {
      if (servers > 1) {
        batches++;
      }
    }
    if (batches == 0) {
      return 0;
    }
    long totalEfficiencies = 0;
    Arrays.sort(capacities);
    for (int i=0; i<batches; i++) {
      totalEfficiencies += capacities[n-i-1] - capacities[i];
    }
    return totalEfficiencies;
  }

  public static void main(String[] args) {
    int n = 4 , k = 2;
    int[] capacities = {3, 6, 1, 2};
    int[] numServers = {1,3};
    System.out.println(getMaximumEfficiency(n, k, capacities, numServers));
    System.out.println(getMaximumEfficiency1(n, k, capacities, numServers));
  }
}
