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

    private int[][] directions = {
        {-1,0}, {0,-1}, {0,1}, {1,0}
    };

    /**
     * TC = O(N.3^L) = there are total N cells and for each cell there are 3 choices and length of the word is L
     * SC = O(N) + O(L) = O(N+L) = recursion call stack is the length of the word
     * @param board
     * @param word
     * @return
     */
    public boolean exist1(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        // start with the first character of the word
        // find if the first character is present in the board
        // if it is present in the board then start DFS from it
        // else return false
        char first = word.charAt(0);
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == first) {
                    // if the DFS return true then return true, else find the first character
                    // in another cell
                    if (findWord(i, j, 0, m, n, board, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean findWord(int i, int j, int index, int m, int n, char[][] board, String word, boolean[][] visited) {

        // if you have reached the end of the word that means you have found all the characters
        // of the word in the board then return true
        if (index == word.length()) {
            return true;
        }

        // 1. check if the cell is out of bound or if the cell is within the bound
        // 2. else check if the cell is previously visited or not
        // 3. else check if the character is the same as the curr character in the word
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        // mark the cell as visited
        visited[i][j] = true;
        for (int[] d : directions) {
            int r = i + d[0];
            int c = j + d[1];
            // if you have found the word then return true, else check for other cells
            if (findWord(r, c, index+1, m, n, board, word, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a'}
        };
        String word = "a";
        System.out.println(exist(board, word));
    }
}
