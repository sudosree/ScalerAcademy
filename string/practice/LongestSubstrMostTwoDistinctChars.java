package string.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrMostTwoDistinctChars {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, right = 0;
        int distinct = 0, maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (freq.get(c) == 1) {
                distinct++;
            }

            // if the window becomes invalid i.e. the no. of distinct
            // characters exceeds two
            while (distinct > 2) {
                char l = s.charAt(left);
                freq.put(l, freq.get(l)-1);
                if (freq.get(l) == 0) {
                    distinct--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcabc";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }
}
