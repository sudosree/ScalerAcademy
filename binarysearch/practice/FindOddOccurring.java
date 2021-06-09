package binarysearch.practice;

public class FindOddOccurring {

    private static int findOddOccurring(int[] A) {
        int n = A.length;
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (mid % 2 == 0) {
                // odd occurring element will be on the right side
                if (mid + 1 < n && A[mid] == A[mid+1]) {
                    low = mid+2;
                }
                // odd occurring element will be on the left side
                else {
                    high = mid-1;
                }
            } else {
                // odd occurring element will be on the right side
                if (mid - 1 >= 0 && A[mid] == A[mid-1]) {
                    low = mid+1;
                }
                // odd occurring element will be on the left side
                else {
                    high = mid-1;
                }
            }
        }
        return low;
    }

    private static int find(int[] A) {
        int idx = findOddOccurring(A);
        return idx == A.length ? -1 : A[idx];
    }

    public static void main(String[] args) {
        int[] A = {2, 2, 3, 3, 2, 2, 4, 4, 3, 3, 1, 1};
        System.out.println(find(A));
    }
}
