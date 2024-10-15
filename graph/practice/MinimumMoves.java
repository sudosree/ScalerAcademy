package graph.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumMoves {

  private static int[][] directions = {
      {-1,0}, {0,-1}, {0,1}, {1,0}
  };

  private static int minMoves(int[][] grid, int k) {
    int m = grid.length, n = grid[0].length;
    // if the source or destination cell has obstacle then destination cell cannot be reached
    if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {
      return -1;
    }
    int[][] dist = new int[m][n];
    for (int i=0; i<m; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    // min distance to reach the source cell is 0
    dist[0][0] = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{0,0});

    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int r = cell[0];
      int c = cell[1];
      // for each direction take upto k steps starting from 1 to k if there is no obstacle
      for (int[] d : directions) {
        for (int step=1; step<=k; step++) {
          int nr = r + d[0] * step;
          int nc = c + d[1] * step;

          // check if the new cell is out of bound or if it has an obstacle
          if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 1) {
            break;
          }

          // if the existing distance is > than the new distance then populate it with the new distance
          if (dist[nr][nc] > dist[r][c] + 1) {
            dist[nr][nc] = dist[r][c] + 1;
            queue.offer(new int[]{nr, nc});
          }
        }
      }
    }
    return dist[m-1][n-1] == Integer.MAX_VALUE ? -1 : dist[m-1][n-1];
  }

  public static void main(String[] args) {
    int[][] grid = {
        {0, 0, 0, 0, 1},
        {1, 1, 0, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 1},
        {0, 0, 0, 0, 0}
    };
    int k = 2;
    System.out.println(minMoves(grid, k));
  }

}
