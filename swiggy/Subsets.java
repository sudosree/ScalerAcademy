package swiggy;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private static List<List<Character>> subsets(String s) {
        List<List<Character>> ans = new ArrayList<>();
        List<Character> choices = new ArrayList<>();
        subsetsHelper(s, 0, choices, ans);
        return ans;
    }

    private static void subsetsHelper(String s, int index, List<Character> choices, List<List<Character>> ans) {
        for (int i=index;i<s.length();i++) {
            choices.add(s.charAt(i));
            ans.add(new ArrayList<>(choices));
            subsetsHelper(s, i+1, choices, ans);
            choices.remove(choices.size()-1);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(subsets(s));
    }
}
