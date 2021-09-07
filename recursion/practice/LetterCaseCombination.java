package recursion.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCaseCombination {

    /**
     * TC = O(n * 2^n)
     * SC = O(n * 2^n)
     * @param s
     * @return
     */
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] ch = s.toCharArray();
        helper(ch, 0, ans);
        return ans;
    }

    private void helper(char[] ch, int pos, List<String> ans) {
        if (pos == ch.length) {
            ans.add(String.valueOf(ch));
            return;
        }
        // if the character is a digit then no need to convert it
        if (ch[pos] >= '0' && ch[pos] <= '9') {
            helper(ch, pos+1, ans);
        } else {
            // convert the character to lowercase
            ch[pos] = Character.toLowerCase(ch[pos]);
            helper(ch, pos+1, ans);
            // convert the character to uppercase
            ch[pos] = Character.toUpperCase(ch[pos]);
            helper(ch, pos+1, ans);
        }
    }

    public List<String> letterCasePermutation1(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                continue;
            }
            int size = queue.size();
            for (int j=0; j<size; j++) {
                String str = queue.poll();
                char[] ch = str.toCharArray();
                ch[i] = Character.toLowerCase(ch[i]);
                queue.offer(String.valueOf(ch));
                ch[i] = Character.toUpperCase(ch[i]);
                queue.offer(String.valueOf(ch));
            }
        }
        return new ArrayList<>(queue);
    }
}
