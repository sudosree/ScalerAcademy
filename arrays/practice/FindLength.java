package arrays.practice;

public class FindLength {

    private static int findLen(int[] arr) {
        int len = 0;
        try {
            while (true) {
                int n = arr[len];
                len++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Exception");
        }
        return len;
    }

    private static int findLen1(int[] arr) {
        int len = 1;
        try {
            while (true) {
                int n = arr[len-1];
                len *= 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            len = binarySearch(arr, 0, len-1);
        }
        return len+1;
    }

    private static int binarySearch(int[] arr, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            try {
                int n = arr[mid];
                low = mid+1;
            } catch (ArrayIndexOutOfBoundsException e) {
                high = mid-1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(findLen(arr));
        System.out.println(findLen1(arr));
    }
}
