package hashmap.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsByQueries {

  private static List<List<String>> groupAnagramsByQueries(String[] words, String[] queries) {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    // for each query string create a frequency string and add it to the hashmap
    for (String query : queries) {
      int[] count = new int[26];
      for (int i=0; i<query.length(); i++) {
        char c = query.charAt(i);
        count[c - 'a']++;
      }
      StringBuilder sb = new StringBuilder();
      for (int i=0; i<26; i++) {
        sb.append("#").append(count[i]);
      }
      map.put(sb.toString(), new ArrayList<>());
    }

    // for each word create a frequency string and check if it is present in the hashmap
    // if the frequency string is present as a key in the hashmap then add the word in the
    // corresponding list
    for (String word : words) {
      int[] count = new int[26];
      for (int i=0; i<word.length(); i++) {
        char c = word.charAt(i);
        count[c - 'a']++;
      }
      StringBuilder sb = new StringBuilder();
      for (int i=0; i<26; i++) {
        sb.append("#").append(count[i]);
      }
      if (map.containsKey(sb.toString())) {
        map.get(sb.toString()).add(word);
      }
    }

    for (String key : map.keySet()) {
      List<String> list = map.get(key);
      list.sort(Comparator.naturalOrder());
      ans.add(list);
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] queries = {"spede", "deul"};
    String[] words = {"duel", "speed", "dule", "cars"};

    System.out.println(groupAnagramsByQueries(words, queries));
  }

}
