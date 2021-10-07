package trie.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestPrefix {

    static class Node {
        private char val;
        private Map<Character, Node> children;
        private boolean isEnd;

        Node(char val) {
            this.val = val;
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    static class Trie {
        private Node root;

        Trie() {
            this.root = new Node(' ');
        }

        private void insert(String word) {
            Node node = root;
            Map<Character, Node> children = node.children;
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (!children.containsKey(c)) {
                    children.put(c, new Node(c));
                }
                node = children.get(c);
                children = node.children;
            }
            node.isEnd = true;
        }

        private String getLongestPrefix(String word) {
            String prefix = "";
            Node node = root;
            Map<Character, Node> children = node.children;
            StringBuilder curr = new StringBuilder();
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (!children.containsKey(c)) {
                    return prefix;
                }
                curr.append(c);
                node = children.get(c);
                if (node.isEnd) {
                    prefix = curr.toString();
                }
                children = node.children;
            }
            return prefix;
        }
    }

    private static String[] longestPrefix(String[] dict, String[] inp) {
        Trie trie = new Trie();
        for (int i=0; i<dict.length; i++) {
            String word = dict[i];
            trie.insert(word);
        }
        String[] ans = new String[inp.length];
        for (int i=0; i<inp.length; i++) {
            String str = inp[i];
            ans[i] = trie.getLongestPrefix(str);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] dict = {"213", "21358", "1234", "12"};
        String[] inp = {"21349049", "1204539492", "123490485904"};
        System.out.println(Arrays.toString(longestPrefix(dict, inp)));
    }
}
