package arrays.practice;

import java.util.Arrays;

public class BubbleSort {

    private static int[] bubbleSort(int[] A) {
        int n = A.length;
        for (int i=0;i<n;i++) {
            boolean swapped = false;
            for (int j=1; j<n-i; j++) {
                if (A[j] < A[j-1]) {
                    int t = A[j];
                    A[j] = A[j-1];
                    A[j-1] = t;
                    swapped = true;
                }
            }
            // if no swapping takes place that means the array is already sorted
            if (!swapped) {
                break;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {5,1,4,2,8};
        System.out.println(Arrays.toString(bubbleSort(A)));
    }
}
