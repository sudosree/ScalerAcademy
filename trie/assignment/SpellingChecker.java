package trie.assignment;

public class SpellingChecker {

    public int[] solve(String[] A, String[] B) {

        Trie trie = new Trie();

        for (int i=0;i<A.length;i++) {
            trie.insert(A[i]);
        }

        int[] ans = new int[B.length];
        for (int i=0;i<B.length;i++) {
            ans[i] = trie.search(B[i]) ? 1 : 0;
        }
        return ans;
    }

    static class Trie {

        private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            int n = word.length();
            for (int i=0;i<n;i++) {
                char c = word.charAt(i);
                if (!node.containsKey(c)) {
                    Node new_node = new Node();
                    node.put(c, new_node);
                }
                node = node.get(c);
            }
            node.setIsEndOfWord();
        }

        public boolean search(String word) {
            Node node = root;
            int n = word.length();
            for (int i=0;i<n;i++) {
                char c = word.charAt(i);
                if (!node.containsKey(c)) {
                    return false;
                }
                node = node.get(c);
            }
            return node.isEndOfWord();
        }
    }

    static class Node {

        private Node[] children;
        private boolean isEndOfWord;

        public Node() {
            this.children = new Node[26];
            this.isEndOfWord = false;
        }

        // check if the character is present or not
        public boolean containsKey(char c) {
            return children[c - 'a'] != null;
        }

        // get the node corresponding to the character c
        public Node get(char c) {
            return children[c - 'a'];
        }

        // add the node as a child to the parent
        public void put(char c, Node node) {
            children[c - 'a'] = node;
        }

        // get isEndOfWord
        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        // set isEndOfWord to true
        public void setIsEndOfWord() {
            this.isEndOfWord = true;
        }
    }
}
