package problemsolving.assignment;

/**
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 *
 * Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.
 *
 * Example :
 *
 * Input:
 *
 * A : [ 1, 4, 5, 8, 10 ]
 * B : [ 6, 9, 15 ]
 * C : [ 2, 3, 6, 6 ]
 *
 * Output:
 *
 * 1
 */
public class MinimizeTheAbsoluteDifference
{

    /**
     * TC = O(P + Q + R)
     */
    private static int solve(int[] A, int[] B, int[] C) {
        int p = A.length, q = B.length, r = C.length;
        int i=0,j=0,k=0;
        int max, min;
        int min_diff = Integer.MAX_VALUE;
        while (i<p && j<q && k<r) {
            int a = A[i], b = B[j], c = C[k];
            max = max(a,b,c);
            if (a < b) {
                if (a < c) {
                    min = a;
                    i++;
                } else {
                    min = c;
                    k++;
                }
            } else {
                if (b < c) {
                    min = b;
                    j++;
                } else {
                    min = c;
                    k++;
                }
            }
            min_diff = Math.min(min_diff, max-min);
        }
        return min_diff;
    }

    private static int max(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                return a;
            }
        } else {
            if (b > c) {
                return b;
            }
        }
        return c;
    }

    public int solve1(int[] A, int[] B, int[] C) {
        int lA = A.length, lB = B.length, lC = C.length;
        int i=0,j=0,k=0;
        int min_diff = Integer.MAX_VALUE;
        while (i < lA && j < lB && k < lC) {
            int a = A[i], b = B[j], c = C[k];
            int max = Math.max(a, Math.max(b,c));
            int min = Math.min(a, Math.min(b,c));
            min_diff = Math.min(min_diff, Math.abs(max-min));
            if (a == min) {
                i++;
            } else if (b == min) {
                j++;
            } else if (c == min) {
                k++;
            }
        }
        return min_diff;
    }

    public static void main(String[] args)
    {
        int[] A = {1, 4, 5, 8, 10};
        int[] B = {6, 9, 15};
        int[] C = {2, 3, 6, 6};
        System.out.println(solve(A,B,C));
    }
}
