package hashmap.assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public static boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkColumn(board) && boxValid(board);
    }

    private static boolean checkRow(char[][] board) {
        for (int r=0; r<9; r++) {
            Set<Character> set = new HashSet<>();
            for (int c=0; c<9; c++) {
                char t = board[r][c];
                if (t != '.') {
                    if (set.contains(t)) {
                        return false;
                    }
                    set.add(t);
                }
            }
        }
        return true;
    }

    private static boolean checkColumn(char[][] board) {
        for (int c=0; c<9; c++) {
            Set<Character> set = new HashSet<>();
            for (int r=0; r<9; r++) {
                char t = board[r][c];
                if (t != '.') {
                    if (set.contains(t)) {
                        return false;
                    }
                    set.add(t);
                }
            }
        }
        return true;
    }

    private static boolean boxValid(char[][] board) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int r=0; r<9; r++) {
            for (int c=0; c<9; c++) {
                int boxId = (r/3) * 3 + (c/3);
                if (!map.containsKey(boxId)) {
                    map.put(boxId, new HashSet<>());
                }
                char t = board[r][c];
                if (t != '.') {
                    if (map.get(boxId).contains(t)) {
                        return false;
                    }
                    map.get(boxId).add(t);
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        // create a hashset for every row, columns and boxes
        // there are total 9 boxes
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i=0; i<9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char t = board[i][j];
                if (t == '.') {
                    continue;
                }
                // if the character t is already present in the hash set
                // then it is a duplicate return false
                if (rows[i].contains(t)) {
                    return false;
                }
                rows[i].add(t);

                // if the character t is already present in the hash set
                // then it is a duplicate return false
                if (cols[j].contains(t)) {
                    return false;
                }
                cols[j].add(t);

                int boxId = (i/3) * 3 + (j/3);
                // if the character t is already present in the hash set
                // then it is a duplicate return false
                if (boxes[boxId].contains(t)) {
                    return false;
                }
                boxes[boxId].add(t);
            }
        }
        return true;
    }

    public boolean isValidSudoku3(char[][] board) {
        // create 9 rows, 9 cols and 9 boxes to keep track of the
        // no.s in each row, each column and each box
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char t = board[i][j];
                if (t == '.') {
                    continue;
                }
                int pos = t - '1';
                // already seen
                if (row[i][pos] == 1) {
                    return false;
                }
                row[i][pos] = 1;

                // already seen
                if (col[j][pos] == 1) {
                    return false;
                }
                col[j][pos] = 1;

                int boxId = (i/3) * 3 + (j/3);
                // already seen
                if (box[boxId][pos] == 1) {
                    return false;
                }
                box[boxId][pos] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        char[][] A = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(A));
    }
}
