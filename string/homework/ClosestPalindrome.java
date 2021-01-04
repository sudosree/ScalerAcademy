package string.homework;

public class ClosestPalindrome
{
    private static String solve(String A) {
        char[] ch = A.toCharArray();
        int n = ch.length;
        int mismatch = 0;
        for (int i=0;i<n/2;i++) {
            if (ch[i] != ch[n-i-1]) {
                mismatch++;
            }
        }
        // if there are more than 1 mismatch
        if (mismatch > 1) {
            return "NO";
        }
        // if there is only one mismatch
        if (mismatch == 1) {
            return "YES";
        }
        // edge case
        if (mismatch == 0) {
            // if there are no mismatch and if the length is even
            if (n%2 == 0) {
                return "NO";
            }
        }
        return "YES";   // if there are no mismatch and if the length is odd
    }

    public static void main(String[] args)
    {
        String A = "adaddb";
        System.out.println(solve(A));
    }
}
