package recursion.practice;

import java.util.Arrays;

public class RatInMaze {

    private static int[][] ratInMaze(int[][] nums) {
        int n = nums.length;
        int[][] ans = new int[n][n];
        backtrack(nums, 0, 0, n, ans);
        return ans;
    }

    private static boolean backtrack(int[][] nums, int i, int j, int n, int[][] ans) {
        if (i == n-1 && j == n-1) {
            if (nums[i][j] == 1) {
                ans[i][j] = 1;
            }
            return true;
        }
        if (i == n || j == n) {
            return false;
        }
        if (nums[i][j] == 1) {
            // mark
            ans[i][j] = 1;
            if (backtrack(nums, i, j+1, n, ans)) {
                return true;
            }
            if (backtrack(nums, i+1, j, n, ans)) {
                return true;
            }
            // unmark
            ans[i][j] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1},
        };
        System.out.println(Arrays.deepToString(ratInMaze(nums)));
    }
}
