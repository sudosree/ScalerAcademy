package string.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {

    private static List<Integer> findAnagrams(char[] text, char[] pat) {
        int n = text.length, m = pat.length;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<m; i++) {
            char c = pat[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        int count = map.size();
        for (int i=0;i<m;i++) {
            char c = text[i];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }
            }
        }
        if (count == 0) {
            ans.add(0);
        }
        for (int i=1;i<n-m+1;i++) {
            char l = text[i-1];
            if (map.containsKey(l)) {
                map.put(l, map.get(l) + 1);
                if (map.get(l) > 0) {
                    count++;
                }
            }
            char r = text[i+m-1];
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);
                if (map.get(r) == 0) {
                    count--;
                }
            }
            if (count == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] text = {'A', 'A', 'A', 'B', 'A', 'B', 'A', 'A'};
        char[] pat = {'A', 'A', 'B', 'A'};
        System.out.println(findAnagrams(text, pat));
    }
}
