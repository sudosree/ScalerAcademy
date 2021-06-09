package binarysearch.practice;

public class FindMissingTerm {

    private static int findMissingTerm(int[] A, int d) {
        int n = A.length;
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            // check the difference between A[mid] and its right neighbor
            if (mid+1 < n && (A[mid+1] - A[mid]) != d) {
                return A[mid] + d;
            }

            // check the difference between A[mid] and its left neighbor
            if (mid-1 >= 0 && (A[mid] - A[mid-1]) != d) {
                return A[mid] - d;
            }

            // if the differences between left and right neighbors with mid are d
            // then check if the left array forms an AP or not
            // if the left half doesn't form an AP then the missing no will be in the left half
            if ((A[mid] - A[0]) != mid * d) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    private static int find(int[] A) {
        int d = (A[A.length-1] - A[0]) / A.length;
        return findMissingTerm(A, d);
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 8, 10, 12, 14};
        System.out.println(find(A));
    }
}
