package arrays.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Description
 *
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :
 *
 *     Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 *     A : For the purpose of this question, YES
 *     Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 *     A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= size of the array <= 1000000
 *
 *
 * Input Format
 *
 * First argument is an array of digits.
 *
 *
 * Output Format
 *
 * Return the array of digits after adding one.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * [1, 2, 3]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [1, 2, 4]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Given vector is [1, 2, 3].
 * The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
public class AddOneToNumber
{
    public static int[] plusOne(int[] A) {
        int n = A.length, carry = 1;
        List<Integer> list = new ArrayList<>();
        for (int i=n-1;i>=0;i--) {
            int sum = carry + A[i];
            if (sum == 10) {
                list.add(0);
                carry = 1;
            } else {
                list.add(sum);
                carry = 0;
            }
        }
        if (carry == 1) {
            list.add(carry);
        }
        int size = list.size();
        while (list.get(size-1) == 0) {
            size--;
        }
        int[] ans = new int[size];
        for (int i=size-1;i>=0;i--) {
            ans[size - i - 1] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] A = {0,4,5,7,8,5};
        int[] res = plusOne(A);
        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
}
