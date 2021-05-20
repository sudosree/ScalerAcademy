package dynamicprogramming.homework;

import java.util.Stack;

public class LongestBalancedSubstring {

    /**
     * TC = O(n), SC = O(n)
     */
    public static int LBSlength(final String A) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i=0;i<A.length();i++) {
            char c = A.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(i);
            } else {
                int j = stack.peek();
                if (j == -1) {
                    stack.push(i);
                } else {
                    char ch = A.charAt(j);
                    if ((ch == '(' && c == ')') || (ch == '[' && c == ']') || (ch == '{' && c == '}')) {
                        stack.pop();
                        maxLen = Math.max(maxLen, i-stack.peek());
                    } else {
                        stack.push(i);
                    }
                }
            }
        }
        return maxLen;
    }

    /**
     * TC = O(n), SC = O(n)
     */
    public int LBSlength1(final String A) {
        int n = A.length();
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i=1;i<n;i++) {
            if (A.charAt(i) == ')' || A.charAt(i) == ']' || A.charAt(i) == '}') {
                if ((A.charAt(i-1) == '(' && A.charAt(i) == ')') || (A.charAt(i-1) == '[' && A.charAt(i) == ']') || (A.charAt(i-1) == '{' && A.charAt(i) == '}')) {
                    dp[i] = (i-2 >= 0 ? dp[i-2] : 0) + 2;
                }
                else if (i-dp[i-1]-1 >= 0 && (
                        (A.charAt(i-dp[i-1]-1) == '(' && A.charAt(i) == ')') || (A.charAt(i-dp[i-1]-1) == '[' && A.charAt(i) == ']') ||
                                (A.charAt(i-dp[i-1]-1) == '{' && A.charAt(i) == '}')
                )) {
                    dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String A = "([[]]()}[";
        System.out.println(LBSlength(A));
    }
}
