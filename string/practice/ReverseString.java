package string.practice;

public class ReverseString {

    private static String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);
        reverse(sb, 0, sb.length()-1);
        reverseWords(sb);
        return sb.toString();
    }

    private static StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length()-1;
        // trim leading spaces
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        // trim trailing spaces
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        // remove multiple spaces in between
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else {
                if (sb.charAt(sb.length()-1) != ' ') {
                    sb.append(c);
                }
            }
            left++;
        }
        return sb;
    }

    private static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char t = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, t);
            left++;
            right--;
        }
    }

    private static void reverseWords(StringBuilder sb) {
        int left = 0, right = 0;
        int n = sb.length();
        while (right < n) {
            // read a word
            while (right < n && sb.charAt(right) != ' ') {
                right++;
            }
            // reverse the word
            reverse(sb, left, right-1);
            right++;
            left = right;
        }
    }

    public static void main(String[] args) {
        String s = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(s));
    }
}
