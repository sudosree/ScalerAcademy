package slidingwindow.practice;

import java.util.HashMap;
import java.util.Map;

public class FindPermutationInPattern {

    private static boolean findPermutation(String s, String p) {
        int m = s.length(), n = p.length();
        Map<Character, Integer> freq = new HashMap<>();
        for (int i=0; i<n; i++) {
            char c = p.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        // no. of distinct characters in the pattern p
        int count = freq.size();
        while (right < m) {
            char r = s.charAt(right);
            if (freq.containsKey(r)) {
                freq.put(r, freq.get(r) - 1);
                if (freq.get(r) == 0) {
                    count--;
                }
            }
            // if the length of the sliding window exceeds n
            // then shrink the window
            if (right - left + 1 > n) {
                char l = s.charAt(left);
                if (freq.containsKey(l)) {
                    freq.put(l, freq.get(l) + 1);
                    if (freq.get(l) > 0) {
                        count++;
                    }
                }
                left++;
            }
            // if the length of the window is equal to the pattern's length
            if (right - left + 1 == n) {
                // if all the characters that are in pattern are present in
                // the window then return true
                if (count == 0) {
                    return true;
                }
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaacb", p = "abc";
        System.out.println(findPermutation(s, p));
    }
}
