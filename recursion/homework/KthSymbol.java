package recursion.homework;

/**
 * Problem Description
 *
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 *
 * Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 20
 *
 * 1 <= B <= 2A - 1
 *
 *
 *
 * Input Format
 *
 * First argument is an integer A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the Bth indexed symbol in row A.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 2
 *  B = 1
 *
 * Input 2:
 *
 *  A = 2
 *  B = 2
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  0
 *
 * Output 2:
 *
 *  1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Row 1: 0
 *  Row 2: 01
 *
 * Explanation 2:
 *
 *  Row 1: 0
 *  Row 2: 01
 */
public class KthSymbol
{
    private static int solve(int A, int B) {
        String res = helper(A);
        return res.charAt(B-1) - '0';
    }

    private static String helper(int A) {
        if (A == 1) {
            return "0";
        }
        String str = helper(A-1);
        StringBuilder res = new StringBuilder();
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == '0') {
                res.append("01");
            } else {
                res.append("10");
            }
        }
        return res.toString();
    }

    public static void main(String[] args)
    {
        int A = 3, B = 1;
        System.out.println(solve(A,B));
    }
}
