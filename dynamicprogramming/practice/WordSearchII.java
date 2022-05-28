package dynamicprogramming.practice;

import java.util.*;

public class WordSearchII {

    private int[] row = {-1, 0, 0, 1};
    private int[] col = {0, -1, 1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (String word : words) {
            for (int i=0; i<m; i++) {
                Arrays.fill(visited[i], false);
            }
            for (int i=0; i<m; i++) {
                boolean flag = false;
                for (int j=0; j<n; j++) {
                    boolean find = helper(board, i, j, m, n, 0, word, visited);
                    if (find) {
                        ans.add(word);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        return ans;
    }

    private boolean helper(char[][] board, int i, int j, int m, int n, int pos, String word, boolean[][] visited) {
        if (pos == word.length()) {
            return true;
        }
        if (!isValid(i, j, m, n) || visited[i][j] || board[i][j] != word.charAt(pos)) {
            return false;
        }
        visited[i][j] = true;
        for (int k=0; k<4; k++) {
            int p = row[k] + i;
            int q = col[k] + j;
            if (helper(board, p, q, m, n, pos+1, word, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean word;

        public TrieNode() {
            this.children = new HashMap<>();
            this.word = false;
        }
    }

    private TrieNode trie = new TrieNode();

    public List<String> findWords1(char[][] board, String[] words) {
        // add all the words in the trie
        for (String word : words) {
            addWord(word);
        }
        Set<String> res = new HashSet<>();
        StringBuilder word = new StringBuilder();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dfs(board, i, j, m, n, visited, trie, word, res);
            }
        }
        return new ArrayList<>(res);
    }

    private void addWord(String word) {
        TrieNode node = trie;
        int m = word.length();
        for (int i=0; i<m; i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }

    private void dfs(char[][] board, int i, int j, int m, int n, boolean[][] visited, TrieNode node, StringBuilder word, Set<String> res) {

        if (!isValid(i, j, m, n) || !node.children.containsKey(board[i][j]) || visited[i][j]) {
            return;
        }
        // mark the cell
        visited[i][j] = true;
        // move to the next node in the trie
        node = node.children.get(board[i][j]);
        word.append(board[i][j]);
        // if this is the end of the word
        if (node.word) {
            res.add(word.toString());
        }
        for (int k=0; k<4; k++) {
            int p = row[k] + i;
            int q = col[k] + j;
            dfs(board, p, q, m, n, visited, node, word, res);
        }
        // backtrack
        // unmark the cell
        visited[i][j] = false;
        // delete the character
        word.deleteCharAt(word.length() - 1);
    }
}
