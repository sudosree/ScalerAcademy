package string.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        int[] freqS = new int[26];
        int[] freqP = new int[26];
        for (int i=0;i<lenP;i++) {
            freqP[p.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        int left = 0;
        for (int right=0;right<lenS;right++) {
            freqS[s.charAt(right) - 'a']++;
            int len = right-left+1;
            if (len == lenP) {
                // check if the frequency are same or not
                if (same(freqS, freqP)) {
                    res.add(left);
                }
                freqS[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return res;
    }

    private static boolean same(int[] freqS, int[] freqP) {
        for (int i=0;i<26;i++) {
            if (freqS[i] != freqP[i]) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i=0;i<p.length();i++) {
            char c = p.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int count = freq.size();
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1);
                // you have seen this character
                if (freq.get(c) == 0) {
                    count--;
                }
            }

            // when the window is valid i.e. if it contains all the characters
            // of p
            while (count == 0) {
                char l = s.charAt(left);
                if (freq.containsKey(l)) {
                    freq.put(l, freq.get(l) + 1);
                    // you are yet to see this character
                    if (freq.get(l) > 0) {
                        count++;
                    }
                }
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "abc";
        System.out.println(findAnagrams(s,t));
    }
}
