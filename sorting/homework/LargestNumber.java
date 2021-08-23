package sorting.homework;

import java.util.*;

/**
 * Problem Description
 *
 * Given a array A of non negative integers, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= len(A) <= 100000
 * 0 <= A[i] <= 2*109
 *
 *
 * Input Format
 *
 * First argument is an array of integers.
 *
 *
 * Output Format
 *
 * Return a string representing the largest number.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [3, 30, 34, 5, 9]
 *
 * Input 2:
 *
 *  A = [2, 3, 9, 0]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  "9534330"
 *
 * Output 2:
 *
 *  "9320"
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  A = [3, 30, 34, 5, 9]
 *  Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
 *
 * Explanation 2:
 *
 *  Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */
public class LargestNumber
{
    /**
     * Time Complexity - O(nlogn)
     * Space Complexity - O(1)
     */
    private static String solve(List<Integer> A) {
        Collections.sort(A, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                String s = String.valueOf(o1);
                String t = String.valueOf(o2);
                String st = s.concat(t);
                String ts = t.concat(s);
                if (st.compareTo(ts) == 0) {
                    return 0;
                }
                // if st > ts then return -1 else return 1
                return st.compareTo(ts) > 0 ? -1 : 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int n : A) {
            sb.append(n);
        }
        // edge case when all the elements are zero {0,0,0,0}, in this case
        // the answer should be zero only i.e. 0
        if (sb.charAt(0) == '0') {
            return sb.substring(sb.length()-1, sb.length());
        }
        return sb.toString();
    }

    public static String largestNumber(final List<Integer> A) {
        Collections.sort(A, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<A.size();i++) {
            sb.append(A.get(i));
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            String s = String.valueOf(a);
            String t = String.valueOf(b);
            String st = s + t;
            String ts = t + s;
            /*if (st.equals(ts)) {
                return 0;
            }*/
            return ts.compareTo(st);
        }
    }

    public static void main(String[] args)
    {
        List<Integer> A = Arrays.asList(54, 546, 548, 60);
        System.out.println(solve(A));
        System.out.println(largestNumber(A));
    }
}
