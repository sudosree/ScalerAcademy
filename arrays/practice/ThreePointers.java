package arrays.practice;

public class ThreePointers {

    public int minimize(final int[] A, final int[] B, final int[] C) {
        int min = Integer.MAX_VALUE;
        int i=0, j=0, k=0;
        int n = A.length, m = B.length, l = C.length;

        while (i < n && j < m && k < l) {
            int a = A[i];
            int b = B[j];
            int c = C[k];

            int diff1 = Math.abs(a - b);
            int diff2 = Math.abs(b - c);
            int diff3 = Math.abs(c - a);

            int maxDiff = Math.max(diff1, Math.max(diff2, diff3));

            if (maxDiff == diff1) {
                if (a > b) {
                    j++;
                } else {
                    i++;
                }
            } else if (maxDiff == diff2) {
                if (b > c) {
                    k++;
                } else {
                    j++;
                }
            } else {
                if (c > a) {
                    i++;
                } else {
                    k++;
                }
            }
            min = Math.min(min, maxDiff);
        }
        return min;
    }

    public int minimize1(final int[] A, final int[] B, final int[] C) {
        int minDiff = Integer.MAX_VALUE;
        int i=0, j=0, k=0;
        int n = A.length, m = B.length, l = C.length;

        while (i < n && j < m && k < l) {
            int a = A[i];
            int b = B[j];
            int c = C[k];

            int min = Math.min(a, Math.min(b, c));
            int max = Math.max(a, Math.max(b, c));

            minDiff = Math.min(minDiff, max - min);

            if (min == a) {
                i++;
            } else if (min == b) {
                j++;
            } else {
                k++;
            }
        }
        return minDiff;
    }
}
