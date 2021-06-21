package dynamicprogramming.practice;

public class PalindromeSubstrings {

    public int countSubstrings(String s) {
        int count = 0;
        for (int start=0; start<s.length(); start++) {
            for (int end=start; end<s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int countSubstringsDP(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n+1][n+1];

        int count = 0;

        // string of length 1 is a valid palindrome
        for (int i=1;i<n+1;i++) {
            pal[i][i] = true;
            count++;
        }

        // string of length 2 is a valid palindrome if
        // both the characters are same
        for (int i=1;i<n;i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                pal[i][i+1] = true;
                count++;
            }
        }

        for (int l=3;l<n+1;l++) {
            int i=1, j=l+i-1;
            while (j < n+1) {
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    pal[i][j] = pal[i+1][j-1];
                    if (pal[i][j]) {
                        count++;
                    }
                } else {
                    pal[i][j] = false;
                }
                i++;
                j++;
            }
        }

        return count;
    }
}
