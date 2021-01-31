package contest;

import java.util.*;

public class MaximumPositivity
{

    /**
     * TC = O(n^2), SC = O(1)
     */
    private static int[] solve(int[] A) {
        int maxLen = Integer.MIN_VALUE;
        int start = -1;
        for (int i=0;i<A.length;i++) {
            for (int j=i;j<A.length;j++) {
                if (A[j] < 0) {
                    break;
                }
                int currLen = j - i + 1;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    start = i;
                }
            }
        }
        int[] res = new int[maxLen];
        for (int i=0;i<maxLen;i++) {
            res[i] = A[start++];
        }
        return res;
    }

    /**
     * TC = O(n), SC = O(1)
     */
    private static int[] solve1(int[] A) {
        int max_len = Integer.MIN_VALUE, start = -1;
        for (int i=0,j=0; i<A.length && j<A.length; j++) {
            if (A[j] < 0) {
                i = j+1;
                continue;
            }
            int curr_len = j - i + 1;
            if (curr_len > max_len) {
                max_len = curr_len;
                start = i;
            }
        }
        int[] ans = new int[max_len];
        for (int i=0;i<max_len;i++) {
            ans[i] = A[start++];
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(solve1(A)));
    }
}
