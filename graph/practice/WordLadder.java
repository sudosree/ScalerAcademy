package graph.practice;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // convert the word list into word set for easy access
        Set<String> wordSet = new HashSet<>(wordList);
        // this set will keep track of the visited words
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int levels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            levels++;
            for (int i=0; i<size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return levels;
                }
                Set<String> neighbors = getNeighbors(word);
                for (String str : neighbors) {
                    if (wordSet.contains(str) && !visited.contains(str)) {
                        queue.offer(str);
                        visited.add(str);
                    }
                }
            }
        }
        return 0;
    }

    private Set<String> getNeighbors(String word) {
        char[] ch = word.toCharArray();
        Set<String> neighbors = new HashSet<>();
        for (int i=0; i<ch.length; i++) {
            char temp = ch[i];
            for (char c='a'; c<='z'; c++) {
                ch[i] = c;
                String str = new String(ch);
                neighbors.add(str);
            }
            ch[i] = temp;
        }
        return neighbors;
    }
}
