package graph.practice;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class FindMaximaCells {

  private static int[][] directions = {
      {-1,0}, {0,-1}, {0,1}, {1,0}
  };

  public static List<int[]> findMaximaCells(int[][] nums) {
    int m = nums.length, n = nums[0].length;
    List<int[]> ans = new ArrayList<>();
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        boolean maxima = true;
        int num = nums[i][j];
        // check if the no. is greater than all of it's four neighbors
        for (int[] d : directions) {
          int r = i + d[0];
          int c = j + d[1];
          if (r >= 0 && r < m && c >= 0 && c < n) {
            if (num <= nums[r][c]) {
              maxima = false;
              break;
            }
          }
        }
        if (maxima) {
          ans.add(new int[]{i, j});
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] nums = {
        {1, 3, 2, 4, 1},
        {5, 6, 7, 2, 1},
        {4, 8, 9, 4, 3},
        {2, 1, 5, 7, 6}
    };

    List<int[]> ans = findMaximaCells(nums);
    for (int[] a : ans) {
      System.out.println(a[0] + " " + a[1] + "\n");
    }
  }
}
