package problemsolving.homework;

import java.util.*;

/**
 * Problem Description
 *
 * Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.
 *
 * NOTE:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A of size N.
 *
 * Second argument is an integer array B of size M.
 *
 *
 *
 * Output Format
 *
 * Return an integer array denoting the common elements.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 2, 1]
 *  B = [2, 3, 1, 2]
 *
 * Input 2:
 *
 *  A = [2, 1, 4, 10]
 *  B = [3, 6, 2, 10, 10]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [1, 2, 2]
 *
 * Output 2:
 *
 *  [2, 10]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
 *
 * Explantion 2:
 *
 *  Elements (2, 10) appears in both the array.
 */
public class CommonElements1
{
    private static int[] solve(int[] A, int[] B) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<A.length;i++) {
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }
        for (int i=0;i<B.length;i++) {
            if (freq.containsKey(B[i]) && freq.get(B[i]) > 0) {
                list.add(B[i]);
                freq.put(B[i], freq.get(B[i]) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i=0;i< list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] A = {2, 1, 4, 10};
        int[] B = {3, 6, 2, 10, 10};
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
