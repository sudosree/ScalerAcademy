package binarysearch.practice;

public class SquareRoot {

    private static int squareRoot(int n) {
        if (n == 0) {
            return 0;
        }
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (mid <= n/mid && mid+1 > n/(mid+1)) {
                return mid;
            }
            if (mid > n/mid) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(16));
    }
}
