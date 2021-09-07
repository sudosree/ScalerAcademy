package hashmap.practice;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length(), m = magazine.length();
        // store the frequency of ransomNote in freq1
        Map<Character, Integer> freq1 = new HashMap<>();
        // store the frequency of magazine in freq2
        Map<Character, Integer> freq2 = new HashMap<>();
        for (int i=0; i<n; i++) {
            char c = ransomNote.charAt(i);
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }
        for (int i=0; i<m; i++) {
            char c = magazine.charAt(i);
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }
        for (int i=0; i<n; i++) {
            char c = ransomNote.charAt(i);
            if (!freq2.containsKey(c)) {
                return false;
            }
            if (freq2.get(c) < freq1.get(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        int n = ransomNote.length(), m = magazine.length();
        if (n > m) {
            return false;
        }
        // store the frequency of ransomNote in freq1
        Map<Character, Integer> freq = new HashMap<>();
        for (int i=0; i<n; i++) {
            char c = ransomNote.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i=0; i<m; i++) {
            char c = magazine.charAt(i);
            if (freq.containsKey(c) && freq.get(c) > 0) {
                freq.put(c, freq.get(c) - 1);
            }
        }
        for (int i=0; i<n; i++) {
            char c = ransomNote.charAt(i);
            if (freq.get(c) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int n = ransomNote.length(), m = magazine.length();
        if (n > m) {
            return false;
        }
        // store the frequency of magazine in freq
        Map<Character, Integer> freq = new HashMap<>();
        for (int i=0; i<m; i++) {
            char c = magazine.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i=0; i<n; i++) {
            char c = ransomNote.charAt(i);
            if (!freq.containsKey(c)) {
                return false;
            }
            // magazine contains insufficient character c
            if (freq.get(c) == 0) {
                return false;
            }
            freq.put(c, freq.get(c) - 1);
        }
        return true;
    }
}
