package trie.practice;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    static class Node {
        private char val;
        private Map<Character, Node> children;
        private boolean isEndOfWord;

        Node(char c) {
            this.val = c;
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(' ');
    }

    /** Inserts a word into the trie. */
    /**
     * TC = O(m) where m = length of the word
     */
    public void insert(String word) {
        Node node = root;
        Map<Character, Node> childList = node.children;
        int n = word.length();

        for (int i=0; i<n; i++) {
            char c = word.charAt(i);
            if (!childList.containsKey(c)) {
                Node newNode = new Node(c);
                childList.put(c, newNode);
            }
            node = childList.get(c);
            childList = node.children;
            if (i == n-1) {
                node.isEndOfWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    /**
     * TC = O(m) where m = length of the word
     */
    public boolean search(String word) {
        Node node = root;
        Map<Character, Node> childList = node.children;
        int n = word.length();

        for (int i=0; i<n; i++) {
            char c = word.charAt(i);
            if (!childList.containsKey(c)) {
                return false;
            }
            node = childList.get(c);
            childList = node.children;
        }
        return node.isEndOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    /**
     * TC = O(m) where m = length of the prefix
     */
    public boolean startsWith(String prefix) {
        Node node = root;
        Map<Character, Node> childList = node.children;
        int n = prefix.length();

        for (int i=0; i<n; i++) {
            char c = prefix.charAt(i);
            if (!childList.containsKey(c)) {
                return false;
            }
            node = childList.get(c);
            childList = node.children;
        }
        return true;
    }
}
