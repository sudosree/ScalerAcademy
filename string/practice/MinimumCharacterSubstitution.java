package string.practice;

import java.util.Arrays;

public class MinimumCharacterSubstitution {

  private static int[] minWordSubstitution(String[] words) {
    int n = words.length;
    int[] ans = new int[n];
    for (int i=0; i<n; i++) {
      String word = words[i];
      ans[i] = minWordChange(word);
    }
    return ans;
  }

  private static int minWordChange(String word) {
    int substitution = 0;
    int n = word.length();
    char[] ch = word.toCharArray();
    for (int i=1; i<n; i++) {
      if (ch[i-1] == ch[i]) {
        substitution++;
        for (char c = 'a'; c <= 'z'; c++) {
          if (ch[i-1] != c && (i+1 >= n || ch[i+1] != c)) {
            ch[i] = c;
            break;
          }
        }
      }
    }
    return substitution;
  }

  public static void main(String[] args) {
    String[] words = {"add", "addd", "adddd", "addddd", "boooook", "break"};
    System.out.println(Arrays.toString(minWordSubstitution(words)));
  }
}
