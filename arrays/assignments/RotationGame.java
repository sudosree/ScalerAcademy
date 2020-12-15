package arrays.assignments;

/**
 * Problem Description
 *
 * Given an array A and a integer B. Return same array after rotating it B times.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A.size() <= 107
 *
 * 1 <= A[i] <= 109
 *
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 *
 * Return an array of integers which is the Bth rotation of input array A
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1,2,3,4]
 * B = 2
 *
 * Input 2:
 *
 * A = [1,2,4]
 * B = 1
 *
 * Input 3:
 *
 * A = [1,2,2]
 * B = 3
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [3,4,1,2]
 *
 * Output 2:
 *
 * [4,1,2]
 *
 * Output 3:
 *
 * [1,2,2]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * [1,2,3,4] => [4,1,2,3] => [3,4,1,2]
 *
 * Explanation 2:
 *
 * [1,2,4] => [4,1,2]
 *
 * Explanation 2:
 *
 * [1,2,2] => [2,1,2] => [2,2,1] => [1,2,2]
 */
public class RotationGame
{
    private static int[] solve2(int[] A, int B) {
        int temp, j;
        for (int i=1;i<=B;i++) {
            temp = A[A.length-1];
            for (j=A.length-1;j>=1;j--) {
                A[j] = A[j-1];
            }
            A[j] = temp;
        }
        return A;
    }

    private static void reverse(int[] A, int left, int right) {
        while(left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }

    private static int[] solve1(int[] A, int B) {
        B = B%A.length;
        reverse(A, 0, A.length-1);
        reverse(A, 0, B-1);
        reverse(A, B, A.length-1);
        return A;
    }

    private static int[] solve(int[] A, int B) {
        int n = A.length;
        int[] ans = new int[n];
        B = B%n;
        for (int i=0;i<n;i++) {
            ans[i] = A[(n-B+i)%n];
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {1,2,3,4,5,6,7,8,9,10};
        int B = 12;
        int[] rotate = solve(A,B);
        for (int i=0;i<rotate.length;i++) {
            System.out.println(rotate[i]);
        }
    }
}
