package dynamicprogramming.practice;

public class WordSearch {

    private static int[] row = {-1, 0, 0, 1};
    private static int[] col = {0, -1, 1, 0};

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                boolean present = wordExist(board, i, j, 0, word, visited, m, n);
                if (present) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean wordExist(char[][] board, int i, int j, int index, String word, boolean[][] visited, int m, int n) {
        // you were able to match the complete word
        if (index == word.length()) {
            return true;
        }
        if (!isValid(i, j, m, n) || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        for (int k=0; k<4; k++) {
            int p = row[k] + i;
            int q = col[k] + j;
            boolean present = wordExist(board, p, q, index+1, word, visited, m, n);
            if (present) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    private static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a'}
        };
        String word = "a";
        System.out.println(exist(board, word));
    }
}
