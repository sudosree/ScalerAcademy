package problemsolving.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * Simba has an integer array of length A. Despite having insisted alot, He is not ready to reveal the array to his friend Expert. But now, he is ready to reveal some hints about the array and challenges Expert to find the values of his hidden array. The hints revealed are as follows:
 *
 * The array is sorted by values.
 * All the elements in the array are distinct and positive (greater than 0).
 * The array contains two elements B and C such that B < C.
 * Difference between all adjacent (consecutive) elements are equal.
 * Among all the arrays satisfying the above conditions, his array has the minimum possible maximum element value.
 *
 * Can you help Expert to construct such an array and surprise Simba?
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= A <= 50
 *
 * 1 <= B < C <= 50
 *
 *
 *
 * Input Format
 *
 * First argument is an integer A.
 *
 * Second argument is an integer B.
 *
 * Third argument is an integer C.
 *
 *
 *
 * Output Format
 *
 * Return a sorted integer array having length N, denoting Simba's Secret Array.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 5
 *  B = 20
 *  C = 50
 *
 * Input 2:
 *
 *  A = 2
 *  B = 2
 *  C = 3
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [10, 20, 30, 40, 50]
 *
 * Output 2:
 *
 *  [2, 3]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Sorted array = [10, 20, 30, 40, 50] satisfies all the conditions having maximum value = 50 minimum possible.
 *  Other arrays such as [20, 30, 40, 50, 60] having max value = 60 or [20, 50, 80, 120] having max value = 120, also satisfy conditions but their maximum value is not minimum possible(As minimum possible max value is 50).
 *
 * Explanation 2:
 *
 *  As the array has only 2 elements, [2, 3] is the only possible candidate.
 */
public class ConstructArray
{

    /**
     * TC = O(n^3), SC = O(1)
     */
    private static int[] solve(int A, int B, int C) {
        int[] ans = new int[A];
        for (int i=0;i<A;i++) {
            ans[i] = Integer.MAX_VALUE;
        }
        for (int a=1;a<50;a++) {
            for (int d=1;d<50;d++) {
                int[] curr = new int[A];
                curr[0] = a;
                for (int i=1;i<A;i++) {
                    curr[i] = a + i * d;
                }
                boolean existB = false, existC = false;
                for (int i=0;i<A;i++) {
                    if (curr[i] == B) {
                        existB = true;
                    } else if (curr[i] == C) {
                        existC = true;
                    }
                }
                // now I have my valid AP because both B and C exists in the AP
                if (existB && existC) {
                    // if the max of current AP is lesser than the max of some previous valid AP
                    // then update the ans to curr
                    if (curr[A-1] < ans[A-1]) {
                        ans = curr;
                    }
                }
            }
        }
        return ans;
    }

    private static List<Integer> findDivisors(int B, int C) {
        List<Integer> list = new ArrayList<>();
        int num = C - B;
        int sqrt = (int)Math.sqrt(num);
        for (int i=1;i<=sqrt;i++) {
            if (num%i == 0) {
                list.add(i);
                // if i divides num then num/i will also divide num
                list.add(num/i);
            }
        }
        return list;
    }

    public static void main(String[] args)
    {
        int A = 5, B = 20, C = 50;
        System.out.println(Arrays.toString(solve(A, B, C)));
        System.out.println(findDivisors(B,C));
    }
}
