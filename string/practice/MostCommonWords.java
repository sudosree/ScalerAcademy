package string.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWords {

    public String mostCommonWord(String paragraph, String[] banned) {
        // step 1: replace all the punctuations with spaces and convert
        // all the characters to lowercase
        String str = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();

        // step 2: split the words by spaces
        String[] words = str.split("\\s+");

        // step 3 : store all the banned words in a set
        Set<String> bannedWords = new HashSet<>();
        for (int i=0;i<banned.length;i++) {
            bannedWords.add(banned[i]);
        }

        // step 4 : store the frequency of all words in the paragraph
        // except the banned words in a hash map
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!bannedWords.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // step 5 : get the word with the maximum frequency
        int maxFreq = 0;
        String res = "";
        for (String word : map.keySet()) {
            int freq = map.get(word);
            if (freq > maxFreq) {
                maxFreq = freq;
                res = word;
            }
        }
        return res;
    }

    public String mostCommonWord1(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (int i=0;i<banned.length;i++) {
            bannedWords.add(banned[i]);
        }
        Map<String, Integer> map = new HashMap<>();
        int maxFreq = 0;
        String res = "";

        char[] ch = paragraph.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<ch.length;i++) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                sb.append(ch[i]);
                if (i != ch.length-1) {
                    continue;
                }
            }
            // end of one word or at the end of a paragraph
            if (sb.length() > 0) {
                String word = sb.toString();
                if (!bannedWords.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    int freq = map.get(word);
                    if (freq > maxFreq) {
                        maxFreq = freq;
                        res = word;
                    }
                }
                // reset the buffer
                sb = new StringBuilder();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "  the  sky is   blue  ";
        s = s.trim();
        String[] t = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<t.length;i++) {
            sb.append(t[i]);
        }
        System.out.println(sb.toString());
    }
}
