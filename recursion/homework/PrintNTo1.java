package recursion.homework;

import java.util.*;

/**
 * Problem Description
 *
 * You are given an integer N, print N to 1 using using recursion.
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 *
 * Input Format
 *
 * First line contains an integer N.
 *
 *
 * Output Format
 *
 * Print N space-separated integers 1 to N.
 * Note: There should be exactly one space after each integer.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * 10
 *
 * Input 2:
 *
 * 5
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 10 9 8 7 6 5 4 3 2 1
 *
 * Output 2:
 *
 * 5 4 3 2 1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Print 10 to 1 space separated integers.
 */
public class PrintNTo1
{
    private static void print(int num) {
        if (num == 0) {
            return;
        }
        System.out.print(num + " ");
        print(num-1);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        print(num);
    }
}
