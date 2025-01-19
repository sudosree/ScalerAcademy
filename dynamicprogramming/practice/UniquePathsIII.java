package dynamicprogramming.practice;

public class UniquePathsIII {

  private static int[][] dirs = new int[][]{
      {-1, 0}, {0, -1}, {0, 1}, {1, 0}
  };
  // no. of paths from the starting cell to the ending cell
  private static int paths = 0;

  public static int uniquePathsIII(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    // no. of empty cells
    int empty = 0;
    // source cell
    int sx = 0, sy = 0;
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (grid[i][j] == 0) {
          empty++;
        } else if (grid[i][j] == 1) {
          sx = i;
          sy = j;
        }
      }
    }
    backtrack(sx, sy, m, n, grid, empty);
    return paths;
  }

  private static void backtrack(int r, int c, int m, int n, int[][] grid, int empty) {
    // if we arrive at the final state i.e.
    // 1. we have reached the destination cell i.e. cell with value 2
    // 2. we have visited all the non obstacle cells including the empty cells (cells with value 0) and the source cell (cell with value 1)
    if (grid[r][c] == 2 && empty == -1) {
      paths++;
      return;
    }
    // mark the cell as visited
    int temp = grid[r][c];
    grid[r][c] = -2;
    // reduce the no. of empty cells
    empty--;
    for (int[] d : dirs) {
      int nr = d[0] + r;
      int nc = d[1] + c;
      // check if the cell is within the range and it is not yet visited and it is not an obstacle
      if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != -1 && grid[nr][nc] != -2) {
        backtrack(nr, nc, m, n, grid, empty);
      }
    }
    // unmark the cell as visited
    grid[r][c] = temp;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][]{
        {1,0,0,0},
        {0,0,0,0},
        {0,0,2,-1}
    };

    System.out.println(uniquePathsIII(grid));
  }
}
