package string.practice;

import java.util.HashSet;
import java.util.Set;

public class MinDeletionsToMakeCharFreqUnique {

    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<26;i++) {
            while (freq[i] > 0 && set.contains(freq[i])) {
                freq[i]--;
                ans++;
            }
            if (freq[i] != 0) {
                set.add(freq[i]);
            }
        }
        return ans;
    }
}
