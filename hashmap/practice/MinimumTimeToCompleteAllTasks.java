package hashmap.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumTimeToCompleteAllTasks {

  private static int findMinTime(int n, int[] memoryTasks, int[] tasks, int maxMemory) {

    // group the tasks by their type
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i=0; i<n; i++) {
      int task = tasks[i];
      if (!map.containsKey(task)) {
        map.put(task, new ArrayList<>());
      }
      map.get(task).add(memoryTasks[i]);
    }

    int minTime = 0;

    // process each task
    // for each task type
    // sort the memory list in descending order
    // group the tasks into batches based on their memory i.e. sum of memory in a batch <= max memory
    // find the min no. of batches for each task type that represent the min time reqd to complete the same task type
    // sum all the batches for all the tasks type

    for (int task : map.keySet()) {
      List<Integer> memories = map.get(task);
      memories.sort(Collections.reverseOrder());
      List<Integer> batches = new ArrayList<>();
      for (int memory : memories) {
        boolean placed = false;
        for (int i=0; i<batches.size(); i++) {
          int batchSum = batches.get(i);
          if (batchSum + memory <= maxMemory) {
            batches.set(i, batchSum + memory);
            placed = true;
            break;
          }
        }
        // if you are unable to place the task in any of the existing batches then create
        // a new batch
        if (!placed) {
          batches.add(memory);
        }
      }
      minTime += batches.size();
    }
    return minTime;
  }

  public static void main(String[] args) {
    int n = 5;
    int[] memoryTasks = {1, 4, 5, 2, 3};
    int[] tasks = {1, 2, 1, 3, 4};
    int maxMemory = 6;
    System.out.println(findMinTime(n, memoryTasks, tasks, maxMemory));
  }
}
