package greedy.practice;

import java.util.*;

public class JobScheduling {

    static class Job {
        char id;
        int deadline;
        int profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    /**
     * TC = O(nlogn + n^2) = O(n^2) (nlogn for sorting, n^2 for finding the required day)
     */
    public static char[] solve(List<Job> jobs) {
        // sort the jobs in descending order based on the profit
        Collections.sort(jobs, new ProfitComparator());
        // get the max deadline of the job
        int max = Integer.MIN_VALUE;
        for (int i=0;i<jobs.size();i++) {
            Job j = jobs.get(i);
            if (j.deadline > max) {
                max = j.deadline;
            }
        }
        boolean[] slots = new boolean[max];
        char[] ch = new char[max];
        for (int i=0;i<jobs.size();i++) {
            Job job = jobs.get(i);
            int deadline = job.deadline;
            for (int j=deadline-1;j>=0;j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    ch[j] = job.id;
                    break;
                }
            }
        }
        return ch;
    }

    /**
     * TC = O(nlogn + nlogn) = O(nlogn)
     */
    public static char[] solve1(List<Job> jobs) {
        // sort the jobs in descending order based on the profit
        Collections.sort(jobs, new ProfitComparator());
        TreeSet<Integer> set = new TreeSet<>();
        // get the max deadline of the job
        int max = Integer.MIN_VALUE;
        for (int i=0;i<jobs.size();i++) {
            Job j = jobs.get(i);
            if (j.deadline > max) {
                max = j.deadline;
            }
            set.add(j.deadline);
        }

        char[] ch = new char[max];
        for (int i=0;i<jobs.size();i++) {
            Job job = jobs.get(i);
            int deadline = job.deadline;
            // if the slot is not filled
            if (set.contains(deadline)) {
                ch[deadline-1] = job.id;
                set.remove(deadline);
            }
            // if the slot is filled
            else {
                if ((set.lower(deadline) != null)) {
                    int nearer_deadline = set.lower(deadline);
                    set.remove(nearer_deadline);
                    ch[nearer_deadline-1] = job.id;
                }

            }
        }
        return ch;
    }

    static class ProfitComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            return o2.profit - o1.profit;
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job('a', 4, 20));
        jobs.add(new Job('b', 1, 10));
        jobs.add(new Job('c', 1, 40));
        jobs.add(new Job('d', 1, 30));
//        jobs.add(new Job('e', 3, 30));

        System.out.println(solve1(jobs));
    }
}
