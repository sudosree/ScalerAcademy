package problemsolving;

import java.util.Arrays;

/**
 * You are given an Array A of size N.
 *
 * Find for how many elements, there is a strictly smaller element and a strictly greater element.
 *
 *
 * Input Format
 *
 * Given only argument A an Array of Integers.
 *
 * Output Format
 *
 * Return an Integer X, i.e number of elements.
 *
 * Constraints
 *
 * 1 <= N <= 1e5
 * 1 <= A[i] <= 1e6
 *
 * For Example
 *
 * Example Input:
 *     A = [1, 2, 3]
 *
 * Example Output:
 *     1
 *
 * Explanation:
 *     only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.
 */
public class StrictlySmallerGreater
{
    private static int solve(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i=1; i< A.length-1; i++) {
            if (A[i] > A[0] && A[i] < A[A.length-1]) {
                count++;
            }
        }
        return count;
    }

    private static int solve1(int[] A) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int count = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
        for (int i=0;i<A.length;i++) {
            if (A[i] > min && A[i] < max) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = {241, 710, 751, 904, 264, 955, 413, 163, 914, 173, 940, 164, 494, 545, 750, 685, 665, 619, 99, 953, 759, 783, 534, 706, 771, 570, 471, 543, 658, 674, 634, 766, 931, 40, 244, 209, 360, 517, 962, 420, 155, 711, 845, 646, 117, 641, 458, 790, 620, 46, 837, 560, 374, 510, 133, 214, 322, 275, 342, 460, 642, 153, 751, 317, 71, 8, 256, 195, 256, 469, 16, 986, 339, 753, 773, 921, 638, 529, 333, 73, 393, 985, 846, 175, 548, 694, 560, 174, 710, 478, 316};
        System.out.println(solve(arr));
    }
}
