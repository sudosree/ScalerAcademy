package trie.assignment;

import java.util.HashMap;
import java.util.Map;

public class PrefixAndSuffix {

    public int[] solve(String[] A, String[] B) {

        int m = B[0].length();

        Trie trie = new Trie();

        // check for how many strings in A whose prefix and suffix of
        // length m are same and add only those strings in the trie
        for (int i=0;i<A.length;i++) {
            String word = A[i];
            boolean check = prefixSuffixSame(word, m);
            if (check) {
                trie.insert(word);
            }
        }

        int[] ans = new int[B.length];
        for (int i=0;i<B.length;i++) {
            String prefix = B[i];
            ans[i] = trie.noOfWordsShareSamePrefix(prefix);
        }
        return ans;
    }

    private boolean prefixSuffixSame(String word, int m) {
        if (word.length() < m) {
            return false;
        }
        int n = word.length();
        for (int i=0;i<m;i++) {
            if (word.charAt(i) != word.charAt(n-m+i)) {
                return false;
            }
        }
        return true;
    }

    static class Trie {

        private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                if (!node.containsKey(c)) {
                    node.put(c, new Node());
                }
                node = node.get(c);
                node.incrementScore();
            }
            node.setIsEndOfWord();
        }

        public int noOfWordsShareSamePrefix(String prefix) {
            Node node = root;
            for (int i=0;i<prefix.length();i++) {
                char c = prefix.charAt(i);
                if (!node.containsKey(c)) {
                    return 0;
                }
                node = node.get(c);
            }
            return node.getScore();
        }
    }

    static class Node {

        private Map<Character, Node> children;
        private boolean isEndOfWord;
        // to check how many words share the same prefix and suffix
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
