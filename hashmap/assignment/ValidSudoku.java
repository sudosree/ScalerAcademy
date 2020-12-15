package hashmap.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * A partially filled sudoku which is valid.
 *
 *     Note:
 *
 *         A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidSudoku
{
    private static int isValidSudoku(String[] A) {
        int[][] grid = new int[9][9];

        // populate the grid
        for (int i=0;i<A.length;i++) {
            String str = A[i];
            for (int j=0;j<str.length();j++) {
                if (str.charAt(j) != '.') {
                    grid[i][j] = str.charAt(j) - '0';
                }
            }
        }

        boolean validRow = true;
        // check if rows are valid i.e. each rows must have the
        // numbers 1-9 occurring just once
        for (int i=0;i<9;i++) {
            // frequency map to store the count of numbers in each row
            Map<Integer, Integer> map = new HashMap<>();
            for (int j=0;j<9;j++) {
                if (grid[i][j] != 0 && !map.containsKey(grid[i][j])) {
                    map.put(grid[i][j], 1);
                }
                // if the count is 1 then the element has already occurred before
                // it is no longer a valid row
                else if (grid[i][j] != 0 && map.get(grid[i][j]) == 1) {
                    validRow = false;
                    break;
                }
            }
            // no need to check the remaining rows
            if (!validRow) {
                break;
            }
        }

        boolean validCol = true;
        // if rows are valid then check columns are valid or not
        if (validRow) {
            for (int i=0;i<9;i++) {
                // frequency map to store the count of numbers in each column
                Map<Integer, Integer> map = new HashMap<>();
                for (int j=0;j<9;j++) {
                    if (grid[j][i] != 0 && !map.containsKey(grid[j][i])) {
                        map.put(grid[j][i], 1);
                    }
                    // if the count is 1 then the element has already occurred before
                    // it is no longer a valid column
                    else if (grid[j][i] != 0 && map.get(grid[j][i]) == 1) {
                        validCol = false;
                        break;
                    }
                }
                // no need to check the remaining columns
                if (!validCol) {
                    break;
                }
            }
        }

        boolean validSubBoxes = true;
        // if both the rows and columns are valid then check sub-boxes are valid or not
        if (validRow && validCol) {
            int rowIdx = 0, colIdx;
            for (int row=0;row<3;row++) {
                rowIdx += 3;
                colIdx = 0;
                for (int col=0;col<3;col++) {
                    colIdx += 3;
                    // frequency map
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int i=rowIdx-3; i<rowIdx; i++) {
                        for (int j=colIdx-3; j<colIdx; j++) {
                            if (grid[i][j] != 0 && !map.containsKey(grid[i][j])) {
                                map.put(grid[i][j], 1);
                            } else if (grid[i][j] != 0 && map.get(grid[i][j]) == 1) {
                                validSubBoxes = false;
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return validRow && validCol && validSubBoxes ? 1 : 0;
    }

    public static void main(String[] args)
    {
        String[] A = {
                "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"
        };
        System.out.println(isValidSudoku(A));
    }
}
