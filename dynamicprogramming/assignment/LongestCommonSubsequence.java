package dynamicprogramming.assignment;

public class LongestCommonSubsequence {

    /**
     * TC = O(2^n)
     */
    public int solve(String A, String B) {
        char[] ch1 = A.toCharArray();
        char[] ch2 = B.toCharArray();
        return lcs(ch1, ch2, ch1.length-1, ch2.length-1);
    }

    private int lcs(char[] A, char[] B, int i, int j) {
        // base case when one of the substring becomes empty
        if (i < 0 || j < 0) {
            return 0;
        }
        int answer = 0;
        if (A[i] == B[j]) {
            answer = 1 + lcs(A, B, i-1, j-1);
        } else {
            answer = Math.max(lcs(A, B, i, j-1), lcs(A, B, i-1, j));
        }
        return answer;
    }

    private int[][] lcs;

    public int solve1(String A, String B) {
        char[] ch1 = A.toCharArray();
        char[] ch2 = B.toCharArray();
        int n = ch1.length;
        int m = ch2.length;
        lcs = new int[n+1][m+1];
        return lcsHelper(ch1, ch2, n-1, m-1);
    }

    /**
     * TC = O(nm), SC = O(nm)
     */
    private int lcsHelper(char[] A, char[] B, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        // already computed
        if (lcs[i][j] > 0) {
            return lcs[i][j];
        }
        if (A[i] == B[j]) {
            lcs[i][j] = 1 + lcsHelper(A, B, i-1, j-1);
        } else {
            lcs[i][j] = Math.max(lcsHelper(A,B,i,j-1), lcsHelper(A,B,i-1,j));
        }
        return lcs[i][j];
    }

    /**
     * TC = O(nm), SC = O(nm)
     */
    public int solve2(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] lcs = new int[n+1][m+1];

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=m;j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }
        return lcs[n][m];
    }

    private static int[][] dp;

    private static int lcs(String A, String B) {
        int n = A.length(), m = B.length();
        dp = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                dp[i][j] = -1;
            }
        }
        return lcsHelper(A, B, n-1, m-1);
    }

    private static int lcsHelper(String A, String B, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (A.charAt(i) == B.charAt(j)) {
            dp[i][j] = 1 + lcsHelper(A, B, i-1, j-1);
        } else {
            dp[i][j] = Math.max(lcsHelper(A, B, i, j-1), lcsHelper(A, B, i-1, j));
        }
        return dp[i][j];
    }

    private static int lcs1(String A, String B) {
        int n = A.length(), m = B.length();
        int[][] dp = new int[n+1][m+1];
        for (int i=1;i<n+1;i++) {
            for (int j=1;j<m+1;j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String A = "abbcdgf";
        String B = "bbadcgf";
        System.out.println(lcs(A,B));
        System.out.println(lcs1(A,B));
    }
}
