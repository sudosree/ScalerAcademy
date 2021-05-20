package dynamicprogramming.practice;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        return uniquePathsHelper(m-1, n-1);
    }

    /**
     * TC = O(2^
     * @param m
     * @param n
     * @return
     */
    private int uniquePathsHelper(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 || n == 0) {
            return 1;
        }
        return uniquePathsHelper(m, n-1) + uniquePathsHelper(m-1, n);
    }

    private int[][] path;

    public int uniquePaths1(int m, int n) {
        path = new int[m][n];
        for (int i=0;i<n;i++) {
            path[0][i] = 1;
        }
        for (int i=0;i<m;i++) {
            path[i][0] = 1;
        }
        return uniquePathsHelper1(m-1, n-1);
    }

    private int uniquePathsHelper1(int m, int n) {
        if (path[m][n] >= 1) {
            return path[m][n];
        }
        path[m][n] = uniquePathsHelper1(m, n-1) + uniquePathsHelper1(m-1, n);
        return path[m][n];
    }

    /**
     * TC = O(m*n), SC = O(m*n)
     */
    public static int uniquePaths2(int m, int n) {
        int[][] path = new int[m][n];
        // 1st row should be 1
        for (int i=0;i<n;i++) {
            path[0][i] = 1;
        }
        // 1st column should be 1
        for (int i=0;i<m;i++) {
            path[i][0] = 1;
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                path[i][j] = path[i][j-1] + path[i-1][j];
            }
        }
        return path[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(3,7));
    }
}
