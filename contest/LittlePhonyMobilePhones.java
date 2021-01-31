package contest;

import java.util.*;

public class LittlePhonyMobilePhones
{

    /**
     * TC = O(Q * n), SC = O(1)
     */
    public static int[] solve(int[] A, int[] B) {
        int[] ans = new int[B.length];
        for (int i=0;i<B.length;i++) {
            int price = B[i];
            int count = 0, sum = 0;
            for (int j=0;j<A.length;j++) {
                sum += A[j];
                if (sum <= price) {
                    count++;
                } else {
                    break;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    /**
     * TC = O(Q * n), SC = O(n)
     */
    public static int[] solve1(int[] A, int[] B) {
        // calculate prefix sum of A
        int[] prefix = new int[A.length];
        prefix[0] = A[0];
        for (int i=1;i<A.length;i++) {
            prefix[i] = prefix[i-1] + A[i];
        }
        int[] ans = new int[B.length];
        for (int i=0;i<B.length;i++) {
            int count = 0;
            for (int j=0;j<A.length;j++) {
                if (prefix[j] <= B[i]) {
                    count++;
                } else {
                    break;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    /**
     * TC = O(Q * logn + n), SC = O(n)
     */
    public static int[] solve2(int[] A, int[] B) {
        // calculate prefix sum of A
        int[] prefix = new int[A.length];
        prefix[0] = A[0];
        for (int i=1;i<A.length;i++) {
            prefix[i] = prefix[i-1] + A[i];
        }
        int[] ans = new int[B.length];
        for (int i=0;i<B.length;i++) {
            ans[i] = binary_search(prefix, B[i]);
        }
        return ans;
    }

    // find the upper bound
    private static int binary_search(int[] prefix, int x) {
        int low = 0, high = prefix.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (mid == 0 && prefix[mid] > x) {
                return 0;
            }
            if (prefix[mid] > x && prefix[mid-1] <= x) {
                return mid;
            }
            if (prefix[mid] <= x) {
                low = mid+1;
            }
            if (prefix[mid-1] > x) {
                high = mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args)
    {
        int[] A = {23,36,58,59};
        int[] B = {3,207,62,654,939,680,760};
        System.out.println(Arrays.toString(solve2(A,B)));
    }
}
