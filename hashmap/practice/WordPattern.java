package hashmap.practice;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        int m = pattern.length();
        String[] str = s.split("\\s+");
        int n = str.length;
        if (m != n) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        char first = pattern.charAt(0);
        String second = str[0];
        map.put(first, second);
        for (int i=1; i<m; i++) {
            char c = pattern.charAt(i);
            String t = str[i];
            if (c != first && t.equals(second)) {
                return false;
            }
            if (c == first && !t.equals(second)) {
                return false;
            }
            if (!map.containsKey(c)) {
                map.put(c, t);
            } else {
                String s1 = map.get(c);
                if (!s1.equals(t)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String s) {
        int m = pattern.length();
        String[] str = s.split("\\s+");
        int n = str.length;
        if (m != n) {
            return false;
        }
        Map<Character, String> mapChar = new HashMap<>();
        Map<String, Character> mapWord = new HashMap<>();
        for (int i=0; i<m; i++) {
            char c = pattern.charAt(i);
            String w = str[i];
            // if the character is not present in the character to word mapping
            if (!mapChar.containsKey(c)) {
                // if the word is present in the word to character mapping
                if (mapWord.containsKey(w)) {
                    return false;
                }
                mapChar.put(c, w);
                mapWord.put(w, c);
            } else {
                String word = mapChar.get(c);
                if (!w.equals(word)) {
                    return false;
                }
            }
        }
        return true;
    }
}
