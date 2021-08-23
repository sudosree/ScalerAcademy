package dynamicprogramming.practice;

public class UniquePathsWithObstacles {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniquePathsWithObstaclesHelper(obstacleGrid, m-1, n-1);
    }

    private static int uniquePathsWithObstaclesHelper(int[][] A, int m, int n) {
        if (m < 0 || n < 0 || A[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        return uniquePathsWithObstaclesHelper(A, m, n-1) + uniquePathsWithObstaclesHelper(A, m-1, n);
    }

    private int[][] path;

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        path = new int[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                path[i][j] = -1;
            }
        }
        return uniquePathsWithObstaclesHelper1(obstacleGrid, m-1, n-1);
    }

    private int uniquePathsWithObstaclesHelper1(int[][] A, int m, int n) {
        if (m < 0 || n < 0 || A[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (path[m][n] >= 0) {
            return path[m][n];
        }
        path[m][n] = uniquePathsWithObstaclesHelper1(A, m, n-1) + uniquePathsWithObstaclesHelper1(A, m-1, n);
        return path[m][n];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        if (obstacleGrid[0][0] == 0) {
            path[0][0] = 1;
        }
        for (int i=1;i<n;i++) {
            if (obstacleGrid[0][i] == 0) {
                path[0][i] = path[0][i-1];
            }
        }
        for (int i=1;i<m;i++) {
            if (obstacleGrid[i][0] == 0) {
                path[i][0] = path[i-1][0];
            }
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                // no obstacle
                if (obstacleGrid[i][j] == 0) {
                    path[i][j] = path[i][j-1] + path[i-1][j];
                }
            }
        }
        return path[m-1][n-1];
    }

    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        // first cell has an obstacle so you cannot reach the destination cell
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        // set the first cell to 1 to continue the path
        obstacleGrid[0][0] = 1;

        // for the first row
        for (int i=1;i<m;i++) {
            // no obstacle
            if (obstacleGrid[0][i] == 0) {
                obstacleGrid[0][i] = obstacleGrid[0][i-1];
            }
            // if there is an obstacle then do not continue the path
            else {
                obstacleGrid[0][i] = 0;
            }
        }

        // for the first column
        for (int i=1;i<n;i++) {
            // no obstacle
            if (obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            }
            // obstacle
            else {
                obstacleGrid[i][0] = 0;
            }
        }

        for (int i=1;i<n;i++) {
            for (int j=1;j<m;j++) {
                // no obstacle
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                }
                // obstacle
                else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] A = {
                {0,0},
                {0,1}
        };
        System.out.println(uniquePathsWithObstacles(A));
    }
}
