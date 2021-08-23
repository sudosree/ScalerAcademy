package greedy.practice;

import java.util.*;

public class MaximumTasksInGivenBudget {

    private static int solve(int n, int t, int[][] tasks) {
        Arrays.sort(tasks, new SortByDistance());
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        int max = 0;
        for (int i=0;i<n;i++) {
            int time = t;
            int distance = 2 * tasks[i][0];
            int timeRemaining = time - distance;
            int effort = tasks[i][1];
            if (queue.isEmpty() && timeRemaining > effort) {
                queue.offer(effort);
                sum += effort;
            } else if (sum + effort <= timeRemaining) {
                queue.offer(effort);
                sum += effort;
            } else {
                int curr = queue.peek();
                if (curr > effort) {
                    queue.poll();
                    queue.offer(effort);
                    sum = sum - curr + effort;
                }
            }
            max = Math.max(max, queue.size());
        }
        return max;
    }

    static class SortByDistance implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0]) {
                return 0;
            }
            return a[0] < b[0] ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        int n = 3, t = 16;
        int[][] tasks = {
                {2,8},
                {4,5},
                {5,1}
        };
        System.out.println(solve(n,t,tasks));
    }
}
