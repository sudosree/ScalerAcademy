package recursion.homework;

/**
 * Problem Description
 *
 * You are given an integer N, print 1 to N using using recursion.
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
 * 1 2 3 4 5 6 7 8 9 10
 *
 * Output 2:
 *
 * 1 2 3 4 5
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Print 1 to 10 space separated integers.
 */
public class Print1ToN
{
    private static void print(int num) {
        if (num == 0) {
            return;
        }
        print(num-1);
        System.out.print(num + " ");
    }

    public static void main(String[] args)
    {
        /*Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();*/
        int num = 10;
        print(num);
    }
}
