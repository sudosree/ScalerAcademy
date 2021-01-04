package recursion.homework;

import java.util.*;

public class LetterCombination
{
    private static Map<Character, String> digitLetterMap = new HashMap<Character, String>(){
        {
            put('0', "0");
            put('1', "1");
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

    private static ArrayList<String> letterCombinations(String A) {
        char[] ch = A.toCharArray();
        return helper(ch,0);
    }

    private static ArrayList<String> helper(char[] ch, int index) {
        if (ch.length - index == 1) {
            String s = digitLetterMap.get(ch[index]);
            ArrayList<String> result = new ArrayList<>();
            for (int i=0;i<s.length();i++) {
                result.add(String.valueOf(s.charAt(i)));
            }
            return result;
        }
        if (ch.length - index == 2) {
            String s = digitLetterMap.get(ch[index]);
            String t = digitLetterMap.get(ch[index+1]);
            ArrayList<String> result = new ArrayList<>();
            for (int i=0;i<s.length();i++) {
                for (int j=0;j<t.length();j++) {
                    result.add(String.valueOf(s.charAt(i)) + t.charAt(j));
                }
            }
            return result;
        }
        ArrayList<String> list = helper(ch, index + 1);
        ArrayList<String> result = new ArrayList<>();
        String p = digitLetterMap.get(ch[index]);
        for (int i=0;i<p.length();i++) {
            for (int j=0;j<list.size();j++) {
                String s = p.charAt(i) + list.get(j);
                result.add(s);
            }
        }
        return result;
    }

    private static List<String> letterCombination(String A) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        letterHelper(A,0,sb,result);
        return result;
    }

    private static void letterHelper(String A, int index, StringBuilder sb, List<String> result) {
        // for empty string
        if (A.length() == 0) {
            return;
        }
        if (index == A.length()) {
            result.add(sb.toString());
            return;
        }
        String s = digitLetterMap.get(A.charAt(index));
        for (int i=0;i<s.length();i++) {
            sb.append(s.charAt(i));
            letterHelper(A,index+1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args)
    {
        String A = "";
        System.out.println(letterCombination(A));
    }
}
