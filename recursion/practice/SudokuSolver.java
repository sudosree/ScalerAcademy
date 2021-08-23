package recursion.practice;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        // move to next row, current row is done
        if (col == 9) {
            col = 0;
            row++;
        }

        // sudoku is solved
        if (row == 9) {
            return true;
        }

        // if the current cell is not empty then move to next cell
        if (board[row][col] != '.') {
            return solve(board, row, col+1);
        }

        // else try to place all the possible no.s from 1 to 9 in the empty cell
        for (char c='1'; c<='9'; c++) {
            // check if the no. can be placed in the empty cell or not
            // if it can be placed then fill the cell with the no.
            if (isValid(board, row, col, c)) {
                board[row][col] = c;

                // move to the next cell, if the next cell returns true then return true
                if (solve(board, row, col+1)) {
                    return true;
                }

                // else the given no. cannot be placed in the current cell
                board[row][col] = '.';
            }
        }
        // no valid moves found
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int startRow = 3 * (row/3), startCol = 3 * (col/3);
        for (int i=0;i<9;i++) {
            // if the row already contains the given no. num then return false
            if (board[row][i] == num) {
                return false;
            }
            // if the column already contains the given no. num then return false
            if (board[i][col] == num) {
                return false;
            }
            // check if the box already contains the given no. or not
            if (board[startRow + i/3][startCol + i%3] == num) {
                return false;
            }
        }
        return true;
    }
}
