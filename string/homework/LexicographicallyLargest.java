package string.homework;

import java.util.*;

public class LexicographicallyLargest
{
    private static String solve(String A) {
        String[] str = A.split("_");
        String s = str[0];
        String t = str[1];
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int n1 = ch1.length;
        int n2 = ch2.length;
        Arrays.sort(ch2);
        // reverse the characters
        for (int i=0;i<n2/2;i++) {
            char c = ch2[i];
            ch2[i] = ch2[n2-i-1];
            ch2[n2-i-1] = c;
        }
        for (int i=0,j=0; i<n1 && j<n2; i++) {
            if (ch1[i] < ch2[j]) {
                ch1[i] = ch2[j];
                j++;
            }
        }
        return new String(ch1);
    }

    public static void main(String[] args)
    {
        String A = "abb_c";
        System.out.println(solve(A));
    }
}
