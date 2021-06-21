package hashmap.practice;

import java.util.HashMap;
import java.util.Map;

public class LengthLongestSubstWithoutRep {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0,j=0;
        int maxLen = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // if it is a repeating character, then shrink the window
            while (map.get(c) > 1) {
                char a = s.charAt(i);
                map.put(a, map.get(a) - 1);
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0, maxLen = 0;
        for (int j=0;j<s.length();j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }
            map.put(c, j);
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }

}
