package string.assignment;

import java.util.*;

public class ReverseString
{

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static String solve(String A) {
        String s = A.trim();
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=str.length-1;i>=0;i--) {
            String t = str[i];
            if (i == 0) {
                sb.append(t);
            } else {
                if (!t.equals("")) {
                    sb.append(t).append(" ");
                }
            }
        }
        return sb.toString();
    }

    private static String solve1(String A) {
        char[] ch = A.toCharArray();
        // reverse the whole string
        reverse(ch, 0, A.length()-1);
        // reverse each word
        reverseWord(ch);
        return removeSpaces(ch);
    }

    private static void reverse(char[] ch, int start, int end) {
        while(start < end) {
            char t = ch[start];
            ch[start] = ch[end];
            ch[end] = t;
            start++;
            end--;
        }
    }

    private static void reverseWord(char[] ch) {
        int n = ch.length;
        int start = 0, end = 0;
        while (start < n) {
            // find the start of a word by skipping spaces
            while (start < n && ch[start] == ' ') {
                start++;
            }
            end = start;
            // find the end of a word by skipping non-spaces
            while (end < n && ch[end] != ' ') {
                end++;
            }
            reverse(ch, start, end-1);
            start = end;
        }
    }

    // remove trailing, leading and extra spaces in between
    private static String removeSpaces(char[] ch) {
        int n = ch.length;
        int start = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        while (start < n) {
            // find the start of a word by skipping spaces
            while (start < n && ch[start] == ' ') {
                start++;
            }
            end = start;
            // find the end of a word by skipping non-spaces
            while (end < n && ch[end] != ' ') {
                end++;
            }
            // append the characters from start to end in a string builder
            for (int i=start;i<end;i++) {
                sb.append(ch[i]);
            }
            if (start < n) {
                // add only one space
                sb.append(' ');
                start = end;
            }
        }
        // remove the extra space
        return sb.substring(0, sb.length()-1);
    }

    // remove trailing, leading and extra spaces in between
    private static String removeSpaces1(char[] ch) {
        int n = ch.length;
        int pos = 0, start = 0;
        while (start < n) {
            // find the start of a word by skipping spaces
            while (start < n && ch[start] == ' ') {
                start++;
            }
            // keep non space character
            while (start < n && ch[start] != ' ') {
                ch[pos++] = ch[start++];
            }
            // skip spaces
            while (start < n && ch[start] == ' ') {
                start++;
            }
            if (start < n) {
                // keep only one space
                ch[pos++] = ' ';
            }
        }
        // remove the extra space
        return new String(ch).substring(0, pos);
    }

    /**
     * Using built in function trim and split
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        // step 1: trim the leading and trailing spaces
        String str = s.trim();

        // step 2: split the words by spaces
        String[] words = str.split("\\s+");

        StringBuilder sb = new StringBuilder();
        // step 3 : reverse each word
        for (String word : words) {
            char[] ch = word.toCharArray();
            reverse(ch);
            sb.append(String.valueOf(ch)).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        // step 4 : reverse the whole string
        char[] p = sb.toString().toCharArray();
        reverse(p);
        return String.valueOf(p);
    }

    private void reverse(char[] ch) {
        int left = 0, right = ch.length - 1;
        while (left < right) {
            char t = ch[left];
            ch[left] = ch[right];
            ch[right] = t;
            left++;
            right--;
        }
    }

    public String reverseWords1(String s) {

        // convert the string to stringbuilder and trim spaces at the same time
        StringBuilder sb = trimSpaces(s);

        // reverse the whole string
        reverse(sb, 0, sb.length()-1);

        // reverse individual words
        reverseWord(sb);

        return sb.toString();
    }

    private StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length()-1;

        // remove all the leading spaces
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        // remove all the trailing spaces
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        // remove the multiple spaces between the words to single space
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else {
                // if the end character of the stringbuilder is not equal to space
                // then add the empty space otherwise do not add
                if (sb.charAt(sb.length()-1) != ' ') {
                    sb.append(c);
                }
            }
            left++;
        }
        return sb;
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char t = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, t);
            left++;
            right--;
        }
    }

    private void reverseWord(StringBuilder sb) {
        int n = sb.length();
        int left = 0, right = 0;
        while (left < n) {
            while (right < n && sb.charAt(right) != ' ') {
                right++;
            }
            // reverse the word
            reverse(sb, left, right-1);
            // move to next word
            left = right + 1;
            right++;
        }
    }

    public static void main(String[] args)
    {
        String A = "   the  sky  is blue   ";
        System.out.println(solve1(A));
    }
}
