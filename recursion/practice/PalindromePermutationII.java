package recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutationII {

    public static List<String> generatePalindromes(String s) {
        int[] map = new int[128];
        List<String> ans = new ArrayList<>();
        if (!canPermutatePalindrome(s, map)) {
            return ans;
        }
        char[] st = new char[s.length()/2];
        char ch = 0;
        int k=0;
        // create a string st with all the characters from string s but with the
        // no. of occurrences reduced to half
        for (int i=0; i<map.length; i++) {
            // if the character has occurred odd no. of times
            if (map[i] % 2 == 1) {
                ch = (char) i;
            }
            for (int j=0; j<map[i]/2; j++) {
                st[k++] = (char) i;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[s.length()/2];
        generatePalindrome(st, ch, used, sb, ans);
        return ans;
    }

    private static void generatePalindrome(char[] st, char ch, boolean[] used, StringBuilder sb, List<String> ans) {
        if (sb.length() == st.length) {
            StringBuilder second = new StringBuilder(sb);
            second.reverse();
            ans.add(sb.toString() + (ch != 0 ? ch : "") + second.toString());
            return;
        }
        for (int i=0;i<st.length;i++) {
            if (used[i] || i > 0 && st[i] == st[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            sb.append(st[i]);
            generatePalindrome(st, ch, used, sb, ans);
            sb.deleteCharAt(sb.length()-1);
            used[i] = false;
        }
    }

    private static boolean canPermutatePalindrome(String s, int[] map) {
        int count = 0;
        for (int i=0;i<s.length();i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(generatePalindromes(s));
    }
}
