package sorting.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DecreasingSorting {

    static class DecreasingComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            return o2 > o1 ? 1 : -1;
        }
    }

    private static List<Integer> solve(List<Integer> A) {
        Collections.sort(A, new DecreasingComparator());
        return A;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(54, 546, 548, 60);
        System.out.println(solve(A));
    }
}
