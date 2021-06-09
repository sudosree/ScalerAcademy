package sorting.practice;

import java.util.Arrays;

public class Quicksort {

    private static void quicksort(int[] A, int low, int high) {
        if (low < high) {
            int pivot = partition(A, low, high);
            quicksort(A, low, pivot-1);
            quicksort(A, pivot+1, high);
        }
    }

    private static int partition(int[] A, int low, int high) {
        int pivot = A[low];
        // find how many elements are less than the pivot
        int count = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i] < pivot) {
                count++;
            }
        }
        // move the pivot with the current position
        int t = A[count];
        A[count] = pivot;
        A[low] = t;
        int left = low, right = high;
        while (left < right) {
            if (A[left] > pivot && A[right] < pivot) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            } else if (A[left] < pivot) {
                left++;
            } else if (A[right] > pivot) {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {50, 23, 9, 18, 61, 32};
        quicksort(A, 0, A.length-1);
        System.out.println(Arrays.toString(A));
    }
}
