package string.practice;

public class Backspace {

  public static boolean compare(String str1, String str2) {
    // TODO: Write your code here
    int first = str1.length()-1, second = str2.length()-1;
    while (first >= 0 || second >= 0) {
      int index1 = getNextValidChar(str1, first);
      int index2 = getNextValidChar(str2, second);

      if (index1 < 0 && index2 < 0) {
        return true;
      }
      if (index1 < 0 || index2 < 0) {
        return false;
      }
      if (str1.charAt(index1) != str2.charAt(index2)) {
        return false;
      }
      first = index1 - 1;
      second = index2 - 1;
    }
    return true;
  }

  private static int getNextValidChar(String str, int index) {
    int backspacecount = 0;
    while (index >= 0) {
      if (str.charAt(index) == '#') {
        backspacecount++;
      } else if (backspacecount > 0) {
        backspacecount--;
      } else {
        break;
      }
      index--;
    }
    return index;
  }

  public static void main(String[] args) {
    String str1 = "xy#z", str2 = "xzz#";
    System.out.println(compare(str1, str2));
  }

}
