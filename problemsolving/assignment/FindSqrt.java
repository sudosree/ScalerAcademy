package problemsolving.assignment;

public class FindSqrt
{
    private static int solve(int num) {
        int res = 0;
        for (int i=1;i<=num;i++) {
            if (i*i <= num) {
                res = i;
            } else {
                break;
            }
        }
        return res;
    }

    // recursive approach
    private static int binarySearch(int num, int left, int right) {
        if (left <= right) {
            int mid = left + (right-left)/2;
            if (mid * mid == num) {
                return mid;
            }
            if (mid * mid > num) {
                return binarySearch(num, left, mid-1);
            }
            return binarySearch(num, mid+1, right);
        }
        return right;
    }

    private static int findSqrt(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (mid * mid == num) {
                return mid;
            }
            if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args)
    {
        int num = 64;
        System.out.println(findSqrt(num));
    }
}
