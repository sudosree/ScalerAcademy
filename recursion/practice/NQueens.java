package recursion.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    /**
     * TC = O(n!), SC = O(n + n + n + n^2) = O(n^2)
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        backtrack(0, n, board, new HashSet<>(), new HashSet<>(), new HashSet<>(), ans);
        return ans;
    }

    private void backtrack(int row, int n, char[][] board, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antidiagonals, List<List<String>> ans) {
        if (row == n) {
            ans.add(addSolution(board));
            return;
        }
        // try to place the queen in the current row at each column
        for (int col=0; col<n; col++) {
            int diagonal = row - col;
            int antidiagonal = row + col;

            // check if there is no other queen present in the same column or
            // same diagonal or same antidiagonal, if it is then the current queen
            // cannot be placed in the current column
            if (cols.contains(col) || diagonals.contains(diagonal) || antidiagonals.contains(antidiagonal)) {
                continue;
            }
            board[row][col] = 'Q';
            cols.add(col);
            diagonals.add(diagonal);
            antidiagonals.add(antidiagonal);
            // try to place the queen in the next row
            backtrack(row + 1, n, board, cols, diagonals, antidiagonals, ans);
            board[row][col] = '.';
            cols.remove(col);
            diagonals.remove(diagonal);
            antidiagonals.remove(antidiagonal);
        }
    }

    private List<String> addSolution(char[][] board) {
        List<String> state = new ArrayList<>();
        for (int i=0; i<board.length; i++) {
            String s = new String(board[i]);
            state.add(s);
        }
        return state;
    }
}
