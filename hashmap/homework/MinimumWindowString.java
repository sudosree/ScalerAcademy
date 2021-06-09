package hashmap.homework;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowString {

    public String minWindow(String A, String B) {
        int[] freq = new int[128];
        int lA = A.length(), lB = B.length();
        for (int i=0;i<lB;i++) {
            freq[B.charAt(i)]++;
        }
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        while (right < lA) {
            char c = A.charAt(right);
            // character c exists in string B
            if (freq[c] > 0) {
                lB--;   // decrement the length of B to keep track of how many characters of B you have seen in the current window
            }
            freq[c]--; // decrement the frequency of character c to keep track of which all characters are processed in the current window

            // as long as the current window contains all the characters of string B, contract/shrink the window
            while (lB == 0) {
                // record the min length seen so far
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    minStart = left;
                }
                c = A.charAt(left);
                freq[c]++;  // increment the character so that it will not be considered any more in the window i.e. shrinking the window
                // if the frequency of the character is positive that means this character is part of the string B
                // and you have to look for this character in the next window
                if (freq[c] > 0) {
                    lB++;  // now the window no longer contains all the characters in string B
                }
                left++;
            }
            right++;
        }
        return minLen != Integer.MAX_VALUE ? A.substring(minStart, minStart+minLen) : "";
    }

    private static String minWindowSubstr(String master, String slave) {
        int n = master.length();
        Map<Character, Integer> freq = new HashMap<>();
        for (int i=0;i<slave.length();i++) {
            freq.put(slave.charAt(i), 0);
        }
        int left = 0, right = 0, minStart = 0, minLen = Integer.MAX_VALUE;

        while (right < n) {
            char r = master.charAt(right);
            if (freq.containsKey(r)) {
                freq.put(r, freq.get(r)+1);
            }
            while (windContainsAllChars(freq)) {
                int currLen = right-left+1;
                if (currLen < minLen) {
                    minLen = currLen;
                    minStart = left;
                }
                char l = master.charAt(left);
                if (freq.containsKey(l)) {
                    freq.put(l, freq.get(l)-1);
                }
                left++;
            }
            right++;
        }
        return master.substring(minStart, minStart+minLen);
    }

    private static boolean windContainsAllChars(Map<Character, Integer> freq) {
        for (char c : freq.keySet()) {
            if (freq.get(c) < 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String master = "ADOBECODEBANC";
        String slave = "ABC";
        System.out.println(minWindowSubstr(master, slave));
    }
}
