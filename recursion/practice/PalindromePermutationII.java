package recursion.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * TC = O((n/2+1)!)
     * SC = O(n)
     * @param s
     * @return
     */
    public List<String> generatePalindromes1(String s) {
        // first check if a palindromic permutation is possible or not
        Map<Character, Integer> freq = new HashMap<>();
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (freq.get(c) % 2 == 0) {
                count--;
            } else {
                count++;
            }
        }
        // palindromic permutation is not possible
        if (count > 1) {
            return new ArrayList<>();
        }
        // else palindromic permutation is possible, generate the first half of the
        // palindromic string
        String mid = "";
        StringBuilder pal = new StringBuilder();
        for (char c : freq.keySet()) {
            int cnt = freq.get(c);
            if (cnt % 2 == 1) {
                mid += c;
            }
            for (int i=0; i<cnt/2; i++) {
                pal.append(c);
            }
        }
        List<String> res = new ArrayList<>();
        StringBuilder permutation = new StringBuilder();
        boolean[] used = new boolean[pal.length()];
        // generate all the permutation of the first half of the string and append the reverse
        // of the permuted string
        permute(pal, used, permutation, res, mid);
        return res;
    }

    private void permute(StringBuilder pal, boolean[] used, StringBuilder permutation, List<String> res, String mid) {

        if (permutation.length() == pal.length()) {
            res.add(permutation.toString() + mid + permutation.reverse().toString());
            // reverse it back
            permutation.reverse();
            return;
        }
        for (int i=0; i< pal.length(); i++) {
            // skip duplicates
            if (i > 0 && pal.charAt(i) == pal.charAt(i-1) && !used[i-1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                permutation.append(pal.charAt(i));
                permute(pal, used, permutation, res, mid);
                permutation.deleteCharAt(permutation.length() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(generatePalindromes(s));
    }
}
