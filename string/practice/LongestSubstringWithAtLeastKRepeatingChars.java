package string.practice;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingChars {

  public int longestSubstring(String s, int k) {
    int n = s.length();
    if (n == 0 || k > n) {
      return 0;
    }
    int maxLen = 0;
    int[] freq = new int[26];
    // generate all the possible substrings
    // and for each substring check if the frequency of all the characters are at least k
    for (int start=0; start<n; start++) {
      Arrays.fill(freq, 0);
      for (int end=start; end<n; end++) {
        freq[s.charAt(end) - 'a']++;
        if (isValid(freq, k)) {
          maxLen = Math.max(maxLen, end - start + 1);
        }
      }
    }
    return maxLen;
  }

  private boolean isValid(int[] freq, int k) {
    int countLetters = 0, countAtLeastK = 0;
    for (int f : freq) {
      if (f > 0) {
        countLetters++;
      }
      if (f >= k) {
        countAtLeastK++;
      }
    }
    return countLetters == countAtLeastK;
  }

  public int longestSubstring1(String s, int k) {
    int n = s.length();
    int maxLen = 0;
    int[] freq = new int[26];
    int maxUnique = getUniqueChars(s);
    for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
      Arrays.fill(freq, 0);
      int left = 0, right = 0;
      // keep track of the no. of unique chars in the current window
      int unique = 0;
      // keep track of the no. of unique chars whose frequency is atleast k in the current window
      int countAtLeastK = 0;
      while (right < n) {
        // expand the window if the no. of curr unique characters is less than or equal to the max unique character
        if (unique <= currUnique) {
          char r = s.charAt(right);
          freq[r - 'a']++;
          if (freq[r - 'a'] == 1) {
            unique++;
          }
          if (freq[r - 'a'] == k) {
            countAtLeastK++;
          }
          right++;
        }

        // shrink the window if the no. of curr unique characters exceeds the max unique character
        else {
          char l = s.charAt(left);
          freq[l - 'a']--;
          if (freq[l - 'a'] == 0) {
            unique--;
          }
          if (freq[l - 'a'] == k-1) {
            countAtLeastK--;
          }
          left++;
        }
        // check if the no. of unique chars are the same as max unique chars and the frequency of every unique characters in the window is at least k
        if (unique == currUnique && unique == countAtLeastK) {
          maxLen = Math.max(maxLen, right - left);
        }
      }
    }
    return maxLen;
  }

  private int getUniqueChars(String s) {
    int distinct = 0;
    int[] freq = new int[26];
    for (int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      freq[c - 'a']++;
      if (freq[c - 'a'] == 1) {
        distinct++;
      }
    }
    return distinct;
  }
}
