package graph.practice;

public class ClosedIsland {

  private static int[][] directions = {
      {-1,0}, {0,-1}, {0,1}, {1,0}
  };

  public static int closedIsland(int[][] grid) {
    int count = 0;
    int m = grid.length, n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (grid[i][j] == 0 && !visited[i][j]) {
          if (dfs(i, j, visited, grid, m, n)) {
            count++;
          }
        }
      }
    }
    return count;
  }

  private static boolean dfs(int i, int j, boolean[][] visited, int[][] grid, int m, int n) {
    // cannot form a closed island as the current cell is out of bound
    if (i < 0 || i >= m || j < 0 || j >= n) {
      return false;
    }
    // if the current cell is a water cell or if it is already visited then return true
    // as it can form a closed island
    if (grid[i][j] == 1 || visited[i][j]) {
      return true;
    }
    visited[i][j] = true;
    boolean isClosed = true;
    for (int[] d : directions) {
      int r = i + d[0];
      int c = j + d[1];
      if (!dfs(r, c, visited, grid, m, n)) {
        isClosed = false;
      }
    }
    return isClosed;
  }

  public static void main(String[] args) {
    int[][] grid = {
        {1,1,1,1,1,1,1,0},
        {1,0,0,0,0,1,1,0},
        {1,0,1,0,1,1,1,0},
        {1,0,0,0,0,1,0,1},
        {1,1,1,1,1,1,1,0}
    };
    System.out.println(closedIsland(grid));
  }
}
