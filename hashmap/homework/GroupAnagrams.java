package hashmap.homework;

import java.util.*;

/**
 * Problem Description
 *
 * Given an array A of N strings, return all groups of strings that are anagrams.
 *
 * Represent a group by a list of integers representing the index(1-based) in the original list. Look at the sample case for clarification.
 *
 * NOTE: Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 104
 *
 * 1 <= |A[i]| <= 104
 *
 * Each string consists only of lowercase characters.
 *
 * Sum of length of all the strings doesn't exceed 107
 *
 *
 *
 * Input Format
 *
 * Single Argument A which is an array of strings.
 *
 *
 * Output Format
 *
 * Return a two-dimensional array where each row describes a group.
 *
 * Note:
 *
 * Ordering of the result :
 * You should not change the relative ordering of the strings within the group suppose within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [cat, dog, god, tca]
 *
 * Input 2:
 *
 *  A = [rat, tar, art]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [ [1, 4],
 *    [2, 3] ]
 *
 * Output 2:
 *
 *  [ [1, 2, 3] ]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  "cat" and "tca" are anagrams which correspond to index 1 and 4 and "dog" and "god" are another set of anagrams which correspond to index 2 and 3.
 *  The indices are 1 based ( the first element has index 1 instead of index 0).
 *
 * Explanation 2:
 *
 *  All three strings are anagrams.
 */
public class GroupAnagrams
{
    private static ArrayList<ArrayList<Integer>> anagrams(List<String> A) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i=0;i<A.size();i++) {
            // frequency array
            int[] count = new int[26];
            String str = A.get(i);
            for (int j=0;j<str.length();j++) {
                count[str.charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            // create a binary string from this frequency array
            for (int j=0;j<26;j++) {
                sb.append(count[j]);
            }
            ArrayList<Integer> arr;
            if (!map.containsKey(sb.toString())) {
                arr = new ArrayList<>();
            } else {
                arr = map.get(sb.toString());
            }
            arr.add(i + 1);
            map.put(sb.toString(), arr);
        }

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (String s : map.keySet()) {
            arr.add(map.get(s));
        }
        return arr;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i=0;i<strs.length;i++) {
            int[] freq = new int[26];
            String s = strs[i];
            for (int j=0;j<s.length();j++) {
                freq[s.charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<26;j++) {
                sb.append("#").append(freq[j]);
            }
            String str = sb.toString();
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            List<String> list = map.get(str);
            list.add(s);
        }

        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    public static void main(String[] args)
    {
        /*List<String> A = Arrays.asList("rat", "tar", "art");
        ArrayList<ArrayList<Integer>> arr = anagrams(A);
        for (int i=0;i<arr.size();i++) {
            for (int j=0;j<arr.get(i).size();j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }*/
        String[] strs = {"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(groupAnagrams(strs));
    }
}
