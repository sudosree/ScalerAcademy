package slidingwindow.practice;

public class LongestRepeatingCharacterReplacement {

  /**
   * Brute Force approach
   * TC = O(n^3), SC = O(n)
   * @param s
   * @param k
   * @return
   */
  public int characterReplacement(String s, int k) {
    int maxLength = 0, n = s.length();
    for (int i=0; i<n; i++) {
      for (int j=i; j<n; j++) {
        // find the max frequency of the character in this substring
        String subStr = s.substring(i,j+1);
        int maxFreqCharCount = getMaxFrequency(subStr);
        // check if the count of other characters is less than or equal to k
        // if it is then it's a valid substring, record the length
        int subStrLen = j-i+1;
        int count = subStrLen - maxFreqCharCount;
        if (count <= k) {
          maxLength = Math.max(maxLength, subStrLen);
        }
      }
    }
    return maxLength;
  }

  private int getMaxFrequency(String s) {
    int maxFreq = 0;
    int[] freq = new int[26];
    for (int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      freq[c - 'A']++;
      maxFreq = Math.max(maxFreq, freq[c - 'A']);
    }
    return maxFreq;
  }

  public int characterReplacement1(String s, int k) {
    int n = s.length();
    // low contains the valid value
    int low = 1;
    // high contains invalid value
    int high = n+1;
    while (low+1 < high) {
      int mid = low + (high-low)/2;
      // can we make a valid substring of length mid
      if (canMakeValidSubstring(s, mid, k)) {
        // explore the right half
        low = mid;
      } else {
        // explore the left half
        high = mid;
      }
    }
    return low;
  }

  private boolean canMakeValidSubstring(String s, int subStringLength, int k) {
    int left = 0, maxFreq = 0;
    int[] freq = new int[26];
    for (int right=0; right<s.length(); right++) {
      char c = s.charAt(right);
      freq[c - 'A']++;
      // check if the window length exceeds the substringLength then shrink the window
      if (right-left+1 > subStringLength) {
        char l = s.charAt(left);
        freq[l - 'A']--;
        left++;
      }
      maxFreq = Math.max(maxFreq, freq[c - 'A']);
      // check if the substring of the given length is valid or not
      if (right-left+1 == subStringLength) {
        if (subStringLength - maxFreq <= k) {
          return true;
        }
      }
    }
    return false;
  }

  public int characterReplacement2(String s, int k) {
    int n = s.length();
    int maxLength = 0, maxFreq = 0;
    int[] freq = new int[26];
    int left = 0;
    for (int right=0; right<n; right++) {
      char c = s.charAt(right);
      freq[c - 'A']++;
      maxFreq = Math.max(maxFreq, freq[c - 'A']);
      // if the window is invalid then shrink it
      if (right-left+1-maxFreq > k) {
        freq[s.charAt(left) - 'A']--;
        left++;
      }
      // window is valid at this point
      maxLength = right-left+1;
    }
    return maxLength;
  }

}
