package graph.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakHelper(String s, Set<String> wordDict, int start) {
        // string is empty
        if (start == s.length()) {
            return true;
        }

        for (int end=start; end<s.length(); end++) {
            String str = s.substring(start, end+1);
            if (wordDict.contains(str) && wordBreakHelper(s, wordDict, end+1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return wordBreakHelper(s, new HashSet<>(wordDict), 0, memo);
    }

    private static boolean wordBreakHelper(String s, Set<String> wordDict, int start, int[] memo) {
        // string is empty
        if (start == s.length()) {
            return true;
        }

        // if the value is already computed
        if (memo[start] != -1) {
            return memo[start] == 1;
        }

        for (int end=start; end<s.length(); end++) {
            String str = s.substring(start, end+1);
            if (wordDict.contains(str) && wordBreakHelper(s, wordDict, end+1, memo)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = 0;
        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n+1];

        // word break of empty string returns true
        dp[0] = true;

        for (int i=1;i<=n;i++) {
            for (int j=0;j<i;j++) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak1(s, wordDict));
    }
}
