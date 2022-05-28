package trie.practice;

import java.util.HashMap;
import java.util.Map;

public class AddSearchWords {

    // create a trie node
    static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean word;

        public TrieNode() {
            this.children = new HashMap<>();
            this.word = false;
        }
    }

    private TrieNode trie;

    public AddSearchWords() {
        this.trie = new TrieNode();
    }

    /**
     * TC = O(m), SC = O(m)
     * @param word
     */
    public void addWord(String word) {
        TrieNode node = trie;
        int m = word.length();
        for (int i=0; i<m; i++) {
            char ch = word.charAt(i);
            // add a new node corresponding to the character ch in the trie
            // if the node is not present in trie
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        // end of the word
        node.word = true;
    }

    /**
     * TC = O(n * 26^m) (where n = no. of words, for each node we have 26 options and length of
     * the word is m), SC = O(1) (for defined word) and O(m) (for undefined word, recursion stack)
     * @param word
     * @return
     */
    public boolean search(String word) {
        return searchInNode(word, trie);
    }

    private boolean searchInNode(String word, TrieNode node) {
        int m = word.length();
        for (int i=0; i<m; i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                if (ch == '.') {
                    // search all the children of this node
                    for (char c : node.children.keySet()) {
                        TrieNode child = node.children.get(c);
                        // search for the remaining characters starting from this node
                        if (searchInNode(word.substring(i+1), child)) {
                            return true;
                        }
                    }
                }
                // the word is not present
                return false;
            } else {
                node = node.children.get(ch);
            }
        }
        return node.word;
    }

    public static void main(String[] args) {
        AddSearchWords dict = new AddSearchWords();
        dict.addWord("a");
        dict.addWord("a");
        System.out.println(dict.search("."));
        System.out.println(dict.search("a"));
        System.out.println(dict.search("aa"));
        System.out.println(dict.search("a"));
        System.out.println(dict.search(".a"));
        System.out.println(dict.search("a."));
    }
}
