package slidingwindow.practice;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

  public static int findLength(char[] arr) {
    int maxLength = 0;
    // TODO: Write your code here
    int n = arr.length;
    int left = 0, right = 0;
    Map<Character, Integer> freq = new HashMap<>();
    while (right < n) {
      char c = arr[right];
      freq.put(c, freq.getOrDefault(c,0)+1);
      while (freq.size() > 2) {
        char l = arr[left];
        freq.put(l, freq.get(l)-1);
        if (freq.get(l) == 0) {
          freq.remove(l);
        }
        left++;
      }
      maxLength = Math.max(maxLength, right-left+1);
      right++;
    }
    return maxLength;
  }

  public static void main(String[] args) {
    char[] arr = {'A', 'B', 'C', 'A', 'C'};
    System.out.println(findLength(arr));
  }

}
