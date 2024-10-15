package recursion.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    static class Tuple {
        int row;
        int col;
        char direction;

        Tuple(int row, int col, char direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }
    }

    private static final List<Tuple> directions = Arrays.asList(
        new Tuple(-1, 0, 'U'),
        new Tuple(0, -1, 'L'),
        new Tuple(0, 1, 'R'),
        new Tuple(1, 0, 'D')
    );

    private static List<String> findPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // if either the source or destination cell is blocked then you cannot reach the destination cell
        if (grid[0][0] == 0 || grid[m-1][n-1] == 0) {
            return new ArrayList<>();
        }
        List<String> allPaths = new ArrayList<>();
        StringBuilder currPath = new StringBuilder();
        findAllPaths(0, 0, grid, m, n, currPath, allPaths);
        return allPaths;
    }

    private static void findAllPaths(int i, int j, int[][] grid, int m, int n, StringBuilder currPath, List<String> allPaths) {
        // if the cell is outside of the grid or if the cell is blocked then you cannot continue the path
        if (i < 0 || i == m || j < 0 || j == m || grid[i][j] == 0) {
            return;
        }
        // if you reach the destination cell then store the curr path in the result list
        if (i == m-1 && j == n-1) {
            allPaths.add(currPath.toString());
            return;
        }
        // mark the cell as visited by blocking it
        grid[i][j] = 0;
        for (Tuple d : directions) {
            int r = i + d.row;
            int c = j + d.col;
            char dir = d.direction;
            // add the direction
            currPath.append(dir);
            findAllPaths(r, c, grid, m, n, currPath, allPaths);
            // remove the previously visited direction
            currPath.deleteCharAt(currPath.length()-1);
        }
        // mark the cell as unvisited
        grid[i][j] = 1;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1},
        };
        System.out.println(Arrays.deepToString(ratInMaze(nums)));
        System.out.println(findPath(nums));
    }
}
