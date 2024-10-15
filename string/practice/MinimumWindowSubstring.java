package string.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    private static String minWindowSubstr(String s, String t) {
        Map<Character, Integer> freqT = new HashMap<>();
        for (int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }
        int start = -1;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> freqS = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // store the frequency of every characters in a window
            freqS.put(c, freqS.getOrDefault(c, 0) + 1);

            // as long as the window is valid, contract the window
            while (valid(freqT, freqS)) {
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    start = left;
                }
                freqS.put(s.charAt(left), freqS.get(s.charAt(left)) - 1);
                left++;
            }
            // when the window is invalid extend the window
            right++;
        }

        if (start == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=start;i<start+minLen;i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private static boolean valid(Map<Character, Integer> freqT, Map<Character, Integer> freqS) {
        for (char key : freqT.keySet()) {
            if (!freqS.containsKey(key) || freqS.get(key) < freqT.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int start = -1;
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int count = freq.size();   // no. of characters in t

        while (right < s.length()) {
            char c = s.charAt(right);
            if (freq.containsKey(c)) {
                // reduce the count
                freq.put(c, freq.get(c)-1);
                // that means you have seen one character from t in the current window
                if (freq.get(c) == 0) {
                    count--;
                }
            }

            // when you have seen all the characters in the current window
            // contract the window
            while (count == 0) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    start = left;
                }
                char l = s.charAt(left);
                if (freq.containsKey(l)) {
                    freq.put(l, freq.get(l) + 1);
                    // you are yet to see this character from string t
                    if (freq.get(l) > 0) {
                        count++;
                    }
                }
                left++;
            }

            // when the window is invalid expand the window
            right++;
        }

        if (start == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=start;i<start+minLen;i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * TC = O(S+T), SC = O(S+T)
     * @param s
     * @param t
     * @return
     */
    public String minWindow1(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS == 0 || lenT == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        int left = 0, start = -1;
        // keep track of the frequency of all characters from t
        Map<Character, Integer> freq = new HashMap<>();
        for (int i=0; i<lenT; i++) {
            char c = t.charAt(i);
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        // no. of unique characters in t which needs to be present in the desired window
        int count = freq.size();
        for (int right=0; right<lenS; right++) {
            char c = s.charAt(right);
            // if the character is present in the freq map, reduce the count of the character
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c)-1);
                // you have seen every occurrence of the character in the current window, reduce the count
                if (freq.get(c) == 0) {
                    count--;
                }
            }
            // if the window is valid i.e. you have seen all the characters in t in
            // the current window
            while (count == 0) {
                int len = right-left+1;
                if (len < minLen) {
                    minLen = len;
                    start = left;
                }
                char l = s.charAt(left);
                // if the character is present in the freq map
                if (freq.containsKey(l)) {
                    freq.put(l, freq.get(l)+1);
                    // you are yet to see the character in the current window
                    if (freq.get(l) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        // no substring exists
        if (start == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=start; i<start+minLen; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        System.out.println(minWindowSubstr(s,t));
        System.out.println(minWindow(s, t));
    }
}
