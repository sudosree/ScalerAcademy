package dynamicprogramming.homework;

import java.util.Stack;

public class LongestValidParentheses {

    /**
     * TC = O(n), SC = O(n)
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i=0; i<n; i++) {
            // all the valid substrings should end at ')'
            if (s.charAt(i) == ')') {
                // if s[i-1] == '(' then its a valid substring
                if (i-1 >= 0 && s.charAt(i-1) == '(') {
                    dp[i] = 2 + ((i-2 >= 0) ? dp[i-2] : 0);
                    maxLen = Math.max(maxLen, dp[i]);
                } else if (i-1 >= 0 && s.charAt(i-1) == ')') {
                    // check what is the character at index (i-dp[i-1]-1)
                    if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                        dp[i] = 2 + dp[i-1] + ((i-dp[i-1]-2 >= 0) ? dp[i-dp[i-1]-2] : 0);
                        maxLen = Math.max(maxLen, dp[i]);
                    }
                }
            }
        }
        return maxLen;
    }

    /**
     * TC = O(n), SC = O(n)
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i-stack.peek());
                }
            }
        }
        return maxLen;
    }

    /**
     * TC = O(n), SC = O(1)
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int maxLen = 0;
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i=n-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }
}
