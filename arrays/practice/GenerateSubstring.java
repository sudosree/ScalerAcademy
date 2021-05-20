package arrays.practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubstring {

    private static List<String> solve(String s) {
        List<String> ans = new ArrayList<>();
        for (int i=0;i<s.length();i++) {
            for (int j=i;j<s.length();j++) {
                ans.add(s.substring(i,j+1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve("abc"));
    }
}
