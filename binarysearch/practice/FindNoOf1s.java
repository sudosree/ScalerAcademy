package binarysearch.practice;

public class FindNoOf1s {

    private static int findNosOf1s(int[] A) {
        int n = A.length;
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (A[mid] == 0 && (mid+1 < n && A[mid+1] == 1)) {
                return mid+1;
            }
            if (A[mid] == 1 && (mid == 0 || A[mid-1] == 0)) {
                return mid;
            }
            if (A[mid] == 0) {
                low = mid+1;
            } else if (A[mid] == 1) {
                high = mid-1;
            }
        }
        return -1;
    }

    private static int find(int[] A) {
        int idx = findNosOf1s(A);
        return idx != -1 ? A.length-idx : 0;
    }

    public static void main(String[] args) {
        int[] A = {0, 0, 0, 0};
        System.out.println(find(A));
    }
}
