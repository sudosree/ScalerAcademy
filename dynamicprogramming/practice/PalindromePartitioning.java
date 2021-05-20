package dynamicprogramming.practice;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /**
     * TC = O(n*2^n) , SC = O(n)
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partitionHelper(s, 0, list, res);
        return res;
    }

    private void partitionHelper(String s, int start, List<String> list, List<List<String>> res)  {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        // generate all possible substrings of a string
        for (int end = start; end < s.length(); end++) {
            String str = s.substring(start, end+1);
            if (isPalindrome(str)) {
                list.add(str);
                partitionHelper(s, end+1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<List<String>> partition1(String s) {
        int n = s.length();
        // will store the value whether the given substring is a palindrome or not
        boolean[][] dp = new boolean[n+1][n+1];

        // fill the value of string with length 1
        for (int i=1;i<n+1;i++) {
            dp[i][i] = true;
        }

        // fill the value of string with length 2
        for (int i=1;i<n;i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                dp[i][i+1] = true;
            }
        }

        for (int l=3;l<n+1;l++) {
            int i=1, j=l+i-1;
            while (j < n+1) {
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    if (dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
                i++;
                j++;
            }
        }

        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partitionHelper(s, 0, list, res, dp);
        return res;
    }

    private void partitionHelper(String s, int start, List<String> list, List<List<String>> res, boolean[][] dp)  {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        // generate all possible substrings of a string
        for (int end = start; end < s.length(); end++) {
            if (dp[start+1][end+1]) {
                list.add(s.substring(start, end+1));
                partitionHelper(s, end+1, list, res, dp);
                list.remove(list.size() - 1);
            }
        }
    }
}
