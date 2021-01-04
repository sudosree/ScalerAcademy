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

    public static void main(String[] args)
    {
        String A = "   the  sky  is blue   ";
        System.out.println(solve1(A));
    }
}
