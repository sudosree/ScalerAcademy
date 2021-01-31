package contest;

/**
 * Given two arrays A and B, array A consists of heights of Christmas trees and array B consists of costs of christmas trees. Choose 3 trees such that the sum of cost is minimized B[p] + B[q] + B[r] and also such that A[p] < A[q] < A[r] where p < q < r
 *
 * A = [1,6,4,2,6,9]
 * B = [2,5,7,3,2,7]
 *
 * ans = 7 is the minimum cost (B[0] + B[3] + B[4] and also A[0] < A[3] < A[4] where 0 < 3 < 4)
 */
public class ChristmasTrees
{

    /**
     * TC = O(n^3), SC = O(1)
     */
    private static int solve(int[] A, int[] B) {
        int min = Integer.MAX_VALUE;
        for (int i=0;i<A.length-2;i++) {
            for (int j=i+1;j<A.length;j++) {
                if (A[j] > A[i]) {
                    for (int k=j+1;k<A.length;k++) {
                        if (A[k] > A[j]) {
                            min = Math.min(min, B[i]+B[j]+B[k]);
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * TC = O(n^2), SC = O(n)
     */
    private static int solve1(int[] A, int[] B) {
        int min_cost_sum = Integer.MAX_VALUE;
        int[] smallest = new int[A.length];
        int[] largest = new int[A.length];
        for (int i=1;i<A.length-1;i++) {
            // find the elements smaller than A[i], if there are multiple smaller elements
            // then take the one whose cost is minimum
            int min_cost = Integer.MAX_VALUE;
            for (int j=0;j<i;j++) {
                if (A[j] < A[i]) {
                    min_cost = Math.min(min_cost, B[j]);
                }
            }
            if (min_cost != Integer.MAX_VALUE) {
                smallest[i] = min_cost;
            }
            min_cost = Integer.MAX_VALUE;
            // find the elements larger than A[i], if there are multiple larger elements
            // then take the one whose cost is minimum
            for (int j=i+1;j<A.length;j++) {
                if (A[j] > A[i]) {
                    min_cost = Math.min(min_cost, B[j]);
                }
            }
            if (min_cost != Integer.MAX_VALUE) {
                largest[i] = min_cost;
            }
            // if there exists A[i] and A[k] then only there exists a triplet
            if (smallest[i] != 0 && largest[i] != 0) {
                min_cost_sum = Math.min(min_cost_sum, smallest[i] + B[i] + largest[i]);
            }
        }
        return min_cost_sum == Integer.MAX_VALUE ? -1 : min_cost_sum;
    }

    /**
     * TC = O(n^2), SC = O(1)
     */
    private static int solve2(int[] A, int[] B) {
        int min_cost_sum = Integer.MAX_VALUE;
        for (int j=1;j<A.length-1;j++) {
            int min_cost_i = Integer.MAX_VALUE, min_cost_k = Integer.MAX_VALUE;
            // find all A[i]'s from 0 to j-1 such that A[i] < A[j] and among all those A[i]'s
            // B[i] is minimum
            for (int i=0;i<j;i++) {
                if (A[i] < A[j] && B[i] < min_cost_i) {
                    min_cost_i = B[i];
                }
            }
            // find all A[k]'s from j+1 to n-1 such that A[k] > A[j] and among all those A[k]'s
            // B[k] is minimum
            for (int k=j+1;k<A.length;k++) {
                if (A[k] > A[j] && B[k] < min_cost_k) {
                    min_cost_k = B[k];
                }
            }
            // if there exists A[i] and A[k] then only there exists a triplet
            if (min_cost_i != Integer.MAX_VALUE && min_cost_k != Integer.MAX_VALUE) {
                min_cost_sum = Math.min(min_cost_sum, min_cost_i + B[j] + min_cost_k);
            }
        }
        return min_cost_sum == Integer.MAX_VALUE ? -1 : min_cost_sum;
    }

    public static void main(String[] args)
    {
        int[] A = {1,6,4,2,6,9};
        int[] B = {2,5,7,3,2,7};
        System.out.println(solve2(A,B));
    }
}
