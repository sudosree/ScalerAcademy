package string.practice;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int n = s.length(), maxLen = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
                String str = s.substring(i, j);
                boolean possible = canReplace(str, k);
                if (possible) {
                    maxLen = Math.max(maxLen, j-i);
                }
            }
        }
        return maxLen;
    }

    private boolean canReplace(String str, int k) {
        int n = str.length(), maxFreq = 0;
        int[] freq = new int[26];
        for (int i=0; i<n; i++) {
            char c = str.charAt(i);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c-'A']);
        }
        return n - maxFreq <= k;
    }

    public int characterReplacement1(String s, int k) {
        int n = s.length(), maxFreq = 0, maxLen = 0;
        int[] freq = new int[26];
        int left = 0, right = 0;
        while (right < n) {
            char r = s.charAt(right);
            freq[r - 'A']++;
            maxFreq = Math.max(maxFreq, freq[r - 'A']);
            // substring's length
            int len = right - left + 1;
            // when you cannot replace all the characters to make the
            // substring contains same characters then shrink the window
            if (len - maxFreq > k) {
                char l = s.charAt(left);
                freq[l - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
