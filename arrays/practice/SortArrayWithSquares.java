package arrays.practice;

import java.util.*;

public class SortArrayWithSquares
{

    /**
     * TC = O(n^2), SC = O(1)
     */
    public static int[] solve(int[] A) {
        int n = A.length;
        for (int i=0;i<n-1;i++) {
            int smallest_index = i;
            for (int j=i+1;j<n;j++) {
                if (Math.abs(A[j]) < Math.abs(A[i])) {
                    smallest_index = j;
                }
            }
            if (smallest_index != i) {
                int t = A[i];
                A[i] = A[smallest_index] * A[smallest_index];
                A[smallest_index] = t;
            }
        }
        return A;
    }

    /**
     * TC = O(n), SC = O(n)
     */
    public int[] solve1(int[] A) {
        int n = A.length;
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        for (int i=0;i<n;i++) {
            if (A[i] < 0) {
                neg.add(Math.abs(A[i]));
            } else {
                pos.add(A[i]);
            }
        }
        int[] ans = new int[n];
        int i=neg.size()-1,j=0,k=0;
        while (i >= 0 && j < pos.size()) {
            if (neg.get(i) < pos.get(j)) {
                ans[k++] = neg.get(i) * neg.get(i);
                i--;
            } else {
                ans[k++] = pos.get(j) * pos.get(j);
                j++;
            }
        }
        while (i >= 0) {
            ans[k++] = neg.get(i) * neg.get(i);
            i--;
        }
        while (j < pos.size()) {
            ans[k++] = pos.get(j) * pos.get(j);
            j++;
        }
        return ans;
    }

    /**
     * TC = O(n), SC = O(1)
     */
    public int[] solve2(int[] A) {
        int n = A.length;
        int i=0, j=n-1,k=n-1;
        int[] ans = new int[n];
        while (i<=j) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                ans[k--] = A[i] * A[i];
                i++;
            } else {
                ans[k--] = A[j] * A[j];
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {-6, -3, -1, 2, 4, 5};
        System.out.println(Arrays.toString(solve(A)));
    }
}
