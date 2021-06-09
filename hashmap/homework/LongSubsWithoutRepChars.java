package hashmap.homework;

import java.util.HashSet;
import java.util.Set;

public class LongSubsWithoutRepChars {

    public int lengthOfLongestSubstring(String s) {
        int max = 0, n = s.length();
        for (int i=0;i<n;i++) {
            Set<Character> set = new HashSet<>();
            for (int j=i;j<n;j++) {
                char c = s.charAt(j);
                // c is a duplicate character, no need to consider the remaining substring
                if (set.contains(c)) {
                    break;
                }
                set.add(c);
                max = Math.max(max, j-i+1);
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String A) {
        int[] freq = new int[128];
        int max = 0;
        int left = 0, right = 0;
        while (right < A.length()) {
            char r = A.charAt(right);
            freq[r]++;
            while (freq[r] > 1) {
                char l = A.charAt(left);
                freq[l]--;
                left++;
            }
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}
