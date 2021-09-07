package string.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            // add the frequency of the current character in the hashmap
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // if the window is invalid i.e. the freq of the character exceeds 1
            // contract the window
            while (freq.get(c) > 1) {
                // remove the character at left index from the window
                freq.put(s.charAt(left), freq.get(s.charAt(left))-1);
                left++;
            }
            // if the window is valid then expand the window
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    private static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        // keep track of repeating characters
        int count = 0;
        while (right < s.length()) {
            // add the frequency of the current character in the hashmap
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (freq.get(c) > 1) {
                count++;
            }

            // if the window is invalid i.e. the freq of the character exceeds 1
            // contract the window
            while (count > 0) {
                char l = s.charAt(left);
                // remove the character at left index from the window
                freq.put(l, freq.get(l) - 1);
                if (freq.get(l) == 1) {
                    count--;
                }
                left++;
            }
            // if the window is valid then expand the window
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        // keep track of the repeating characters and its indices
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int right = 0; right <s.length(); right++) {
            char c = s.charAt(right);
            // if the character is already present in the map at index j then skip
            // all the characters from left to j and shift the window to j+1 directly
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring1(s));
    }
}
