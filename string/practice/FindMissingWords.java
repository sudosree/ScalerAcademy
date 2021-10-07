package string.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingWords {

    private static List<String> findMissingWords(String s, String t) {
        Set<String> set = new HashSet<>();
        String[] str = t.split(" ");
        for (int i=0; i<str.length; i++) {
            set.add(str[i]);
        }
        List<String> ans = new ArrayList<>();
        String[] p = s.split(" ");
        for (int i=0; i<p.length; i++) {
            if (!set.contains(p[i])) {
                ans.add(p[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "I am using HackerRank to improve programming";
        String t = "am HackerRank to improve";
        System.out.println(findMissingWords(s, t));
    }
}
