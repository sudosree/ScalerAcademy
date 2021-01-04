package recursion.assignment;

public class Palindrome
{
    private static int checkPalindrome(String A, int start, int end) {
        // if A is of length 1
        if (start == end) {
            return 1;
        }
        // if A is of length 2
        if (end-start == 1) {
            return A.charAt(start) == A.charAt(end) ? 1 : 0;
        }
        // if A is of length 3
        if (end-start == 2) {
            return A.charAt(start) == A.charAt(end) ? 1 : 0;
        }
        return A.charAt(start) == A.charAt(end) && checkPalindrome(A,start+1,end-1) == 1 ? 1 : 0;
    }

    private static int solve(String A) {
        return checkPalindrome(A,0,A.length()-1);
    }

    public static void main(String[] args)
    {
        String A = "abc";
        System.out.println(solve(A));
    }
}
