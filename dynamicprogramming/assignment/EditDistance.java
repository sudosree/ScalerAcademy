package dynamicprogramming.assignment;

public class EditDistance {

    /**
     * TC = O(nm), SC = O(nm)
     * @param A
     * @param B
     * @return
     */
    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();

        // dp state, ed[i][j] will store the minimum edit distance between
        // first i characters of string word1 and the first j characters of
        // string word2
        int[][] ed = new int[n+1][m+1];

        // base case when string word2 has no characters
        for (int i=0;i<n+1;i++) {
            ed[i][0] = i;
        }
        // base case when string word1 has no characters
        for (int j=0;j<m+1;j++) {
            ed[0][j] = j;
        }

        for (int i=1;i<n+1;i++) {
            for (int j=1;j<m+1;j++) {
                // if the characters are same then do not need to do anything
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    ed[i][j] = ed[i-1][j-1];
                } else {
                    int insert = 1 + ed[i][j-1];
                    int delete = 1 + ed[i-1][j];
                    int replace = 1 + ed[i-1][j-1];
                    ed[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return ed[n][m];
    }

    private int[][] dp;

    public int minDistance1(String A, String B) {
        int n = A.length(), m = B.length();
        if (n == 0 && m == 0) {
            return 0;
        }
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        dp = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                dp[i][j] = -1;
            }
        }
        return minDistanceHelper(A, B, n-1, m-1);
    }

    private int minDistanceHelper(String A, String B, int i, int j) {
        if (i < 0 && j < 0) {
            return 0;
        }
        if (i < 0) {
            return j+1;
        }
        if (j < 0) {
            return i+1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (A.charAt(i) == B.charAt(j)) {
            dp[i][j] = minDistanceHelper(A, B, i-1, j-1);
        } else {
            // found a match for B[j]
            int insert = 1 + minDistanceHelper(A, B, i, j-1);
            // found a match for A[i]
            int delete = 1 + minDistanceHelper(A, B, i-1, j);
            // both A[i] and B[j] matches
            int replace = 1 + minDistanceHelper(A, B, i-1, j-1);
            dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
        return dp[i][j];
    }
}
