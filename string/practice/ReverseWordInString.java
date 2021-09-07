package string.practice;

public class ReverseWordInString {

    public static String reverseWords(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int left = 0, right = 0;
        while (right < n) {
            if (ch[right] != ' ') {
                right++;
            } else {
                reverse(ch, left, right-1);
                right++;
                left = right;
            }
        }
        reverse(ch, left, right-1);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }

    private static void reverse(char[] ch, int left, int right) {
        while (left < right) {
            char t = ch[left];
            ch[left] = ch[right];
            ch[right] = t;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
