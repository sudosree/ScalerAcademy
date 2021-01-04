package sorting.homework;

/**
 * Problem Description
 *
 * Given an array of integers A of size, N. Minimize the absolute difference between the maximum and minimum element of the array.
 *
 * You can perform two types of operations at most B times in total to change the values in the array.
 * Multiple operations can be performed on the same element.
 *
 *     Increment : A[i] -> A[i] + 1.
 *
 *     Decrement : A[i] -> A[i] - 1.
 *
 *     Return the minimum difference possible.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 106
 *
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 * Second argument is an integer B which represents the maximum number of operations that can be performed.
 *
 *
 * Output Format
 *
 * Return an integer denoting the minimum difference.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [2, 6, 3, 9, 8]
 *  B = 3
 *
 * Input 2:
 *
 *  A = [4, 6, 3, 1, 4]
 *  B = 5
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  5
 *
 * Output 2:
 *
 *  1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  We can apply the atmost 3 operations in the following sequence.
 *  Initial array => [2, 6, 3, 9, 8].
 *    Decrement 9 => [2, 6, 3, 8, 8].
 *    Increment 2 => [3, 6, 3, 8, 8].
 *    Increment 3 => [3, 6, 4, 8, 8].
 *  Max = 8. Min = 3.
 *  Therefore, abs|Max - Min| = |8 - 3| = 5.
 *
 * Explanation 2:
 *
 *  We can apply the atmost 5 operations in the following sequence.
 *  Initial array => [4, 6, 3, 1, 4].
 *    Increment 1 => [4, 6, 3, 2, 4].
 *    Decrement 6 => [4, 5, 3, 2, 4].
 *    Increment 2 => [4, 5, 3, 3, 4].
 *    Decrement 5 => [4, 4, 3, 3, 4].
 *    Increment 3 => [4, 4, 4, 3, 4].
 *  Max = 4. Min = 3.
 *  Therefore, abs|Max - Min| = |4 - 3| = 1.
 */
public class MinimizeDifference
{

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static int solve(int[] A, int B) {
        // first find the min and max of the array
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] freq = new int[1000001];
        for (int i=0;i<A.length;i++) {
            freq[A[i]]++;
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }

        while (min < max) {
            int countMin = freq[min];
            int countMax = freq[max];
            if (countMin >= countMax) {
                // decrement max
                if (freq[max] <= B) {
                    freq[max-1] = freq[max] + freq[max-1];
                    // reduce the operation of B by freq[max] times
                    B = B - freq[max];  // decrementing the value of B by freq[max] steps
                    max--;
                } else {
                    break;
                }
            } else {
                // increment min
                if (freq[min] <= B) {
                    freq[min+1] = freq[min] + freq[min+1];
                    // reduce the operation of B by freq[min] times
                    B = B - freq[min];  // decrementing the value of B by freq[min] steps
                    min++;
                } else {
                    break;
                }
            }
        }
        return max-min;
    }

    /**
     * Time Complexity = O(n) + O(B) = O(B) as B > n
     * Space Complexity - O(n)
     */
    public int solve1(int[] A, int B) {
        // first find the min and max of the array
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] freq = new int[1000001];
        for (int i=0;i<A.length;i++) {
            freq[A[i]]++;
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }
        int diff = max - min;
        for (int i=0;i<B;i++) {
            int countMin = freq[min];
            int countMax = freq[max];
            if (countMin >= countMax) {
                // decrement max
                int prevMax = max;
                freq[max]--;
                max--;
                freq[max]++;
                if (freq[prevMax] != 0) {
                    max = prevMax;
                }
            } else {
                // increment min
                int prevMin = min;
                freq[min]--;
                min++;
                freq[min]++;
                if (freq[prevMin] != 0) {
                    min = prevMin;
                }
            }
            if (Math.abs(max-min) < diff) {
                diff = Math.abs(max - min);
            }
        }
        return diff;
    }

    public static void main(String[] args)
    {
        int[] A = {2,2,4,6,8,9,9,9,9};
        int B = 20;
        System.out.println(solve(A,B));
    }
}
