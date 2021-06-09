package sorting.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNo {

    static class LargestComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String s = String.valueOf(o1);
            String t = String.valueOf(o2);
            String st = s.concat(t);
            String ts = t.concat(s);
            return ts.compareTo(st);
        }
    }

    private static String findLargestNo(List<Integer> A) {
        Collections.sort(A, new LargestComparator());
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<A.size();i++) {
            sb.append(A.get(i));
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(0,0,0);
        System.out.println(findLargestNo(A));
    }
}
