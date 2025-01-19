package string.practice;

public class ValidAnagram {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] count = new int[26];
    for (int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      count[c - 'a']++;
    }
    for (int i=0; i<t.length(); i++) {
      char c = t.charAt(i);
      count[c - 'a']--;
      if (count[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}
