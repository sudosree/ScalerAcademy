package hashmap.homework;

import java.util.*;

/**
 * Problem Description
 *
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographicaly in this alien language else return 0.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N, length of each word <= 105
 *
 * Sum of length of all words <= 2 * 106
 *
 *
 *
 * Input Format
 *
 * First argument is a string array A of size N.
 *
 * Second argument is a string B of size 26 denoting the order.
 *
 *
 *
 * Output Format
 *
 * Return 1 if and only if the given words are sorted lexicographicaly in this alien language else return 0.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = ["hello", "scaler", "interviewbit"]
 *  B = "adhbcfegskjlponmirqtxwuvzy"
 *
 * Input 2:
 *
 *  A = ["fine", "none", "no"]
 *  B = "qwertyuiopasdfghjklzxcvbnm"
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 *
 * Output 2:
 *
 *  0
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  The order shown in string B is: h < s < i for the given words. So return 1.
 *
 * Explanation 2:
 *
 *  "none" should be present after "no". Return 0.
 */
public class IsDictionary
{
    private static int solve(String[] A, String B) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i=0;i<26;i++) {
            charMap.put(B.charAt(i), i+1);
        }
        String s = A[0];
        for (int i=1;i<A.length;i++) {
            String t = A[i];
            if (!checkLexicographicalOrder(charMap, s, t)) {
                return 0;
            }
            s = A[i];
        }
        return 1;
    }

    private static boolean checkLexicographicalOrder(Map<Character,Integer> map, String s, String t) {
        if (map.get(s.charAt(0)) < map.get(t.charAt(0))) {
            return true;
        }
        if (map.get(s.charAt(0)) > map.get(t.charAt(0))) {
            return false;
        }
        int i=0,j=0;
        while (i<s.length() && j<t.length() && map.get(s.charAt(i)).equals(map.get(t.charAt(j)))) {
            i++;
            j++;
        }
        if (i<s.length() && j<t.length()) {
            return map.get(s.charAt(i)) < map.get(t.charAt(j));
        }
        if (i<s.length() && j == t.length()) {
            return false;
        }
        return true;
    }

    private static int solve1(String[] A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<B.length();i++) {
            map.put(B.charAt(i),i);
        }
        for (int i=1;i<A.length;i++) {
            String s = A[i-1];
            String t = A[i];
            for (int j=0;j< Math.min(s.length(), t.length());j++) {
                // find the first character for which s.charAt(j) < t.charAt(j)
                // the position of j might be 0 or not 0, if the position of j is 0 then this is the first character
                // you don't need to check for the remaining character else it might be at any other position and all the
                // characters before that position were equal
                if (map.get(s.charAt(j)) < map.get(t.charAt(j))) {
                    break;
                }
                // find the first character for which s.charAt(j) > t.charAt(j)
                if (map.get(s.charAt(j)) > map.get(t.charAt(j))) {
                    return 0;
                }
            }
            // also check if length(s) > length(t)
            if (s.length() > t.length()) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args)
    {
        String[] A = {"hellop", "hello"};
        String B = "nbpfhmirzqxsjwdoveuacykltg";
        System.out.println(solve1(A,B));
    }
}
