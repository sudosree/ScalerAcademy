package maths.homework;

/**
 *
 Reverse integer

 Problem Description

 You are given an integer N and the task is to reverse the digits of the given integer. Return 0 if the result overflows and does not fit in a 32 bit signed integer

 Look at the example for clarification.


 Problem Constraints

 N belongs to the Integer limits.


 Input Format

 Input an Integer.


 Output Format

 Return a single integer denoting the reverse of the given integer.


 Example Input

 Input 1:

 x = 123


 Input 2:

 x = -123



 Example Output

 Output 1:

 321


 Ouput 2:

 -321



 Example Explanation

 If the given integer is negative like -123 the output is also negative -321.
 */
public class ReverseInteger
{
    private static int reverse(int A) {
        int ans = 1;
        if (A < 0) {
            ans = -1;
            A *= ans;
        }
        long rev = 0;
        while (A > 0) {
            int digit = A%10;
            rev = rev * 10 + digit;
            A /= 10;
        }
        rev = ans * rev;
        if (rev < 0 && rev >= Integer.MIN_VALUE) {
            return (int)rev;
        }
        if (rev > 0 && rev <= Integer.MAX_VALUE) {
            return (int)rev;
        }
        return 0;
    }

    public static void main(String[] args)
    {
        int A = -2147483647;
        System.out.println(reverse(A));
    }
}
