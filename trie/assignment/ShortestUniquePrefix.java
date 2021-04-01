package trie.assignment;

import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

    /**
     * TC = O(n*l + n*m) (where n = length of array A, l = average length of string in A,
     * m = max length of string in A)
     * SC = O(n*l)
     */
    public String[] prefix(String[] A) {

        Trie trie = new Trie();

        for (int i=0;i<A.length;i++) {
            trie.insert(A[i]);
        }

        String[] ans = new String[A.length];
        for (int i=0;i<A.length;i++) {
            ans[i] = trie.findShortestUniquePrefix(A[i]);
        }
        return ans;
    }

    static class Trie {

        private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for (int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                if (!curr.containsKey(c)) {
                    curr.put(c, new Node());
                }
                curr = curr.get(c);
                curr.incrementScore();
            }
            curr.setIsEndOfWord();
        }

        public String findShortestUniquePrefix(String word) {
            StringBuilder sb = new StringBuilder();
            Node curr = root;
            for (int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                curr = curr.get(c);
                sb.append(c);
                if (curr.getScore() == 1) {
                    break;
                }
            }
            return sb.toString();
        }
    }

    static class Node {
        private Map<Character, Node> children;
        private boolean isEndOfWord;
        private int score;

        public Node() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
            this.score = 0;
        }

        public boolean containsKey(char c) {
            return children.containsKey(c);
        }

        public Node get(char c) {
            return children.get(c);
        }

        public void put(char c, Node node) {
            children.put(c, node);
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setIsEndOfWord() {
            this.isEndOfWord = true;
        }

        public int getScore() {
            return score;
        }

        public void incrementScore() {
            this.score++;
        }
    }
}
