package recursion.practice;

import java.util.*;

public class GenerateParentheses
{

    /**
     * Brute Force Approach
     */
    public static List<String> generateParentheses(int n) {
        List<String> combinations = new ArrayList<>();
        // generate all the possible combinations/sequences of parentheses and
        // then check if those are valid or not
        // total there will be 2^2n sequences and the length will be 2 * n
        generateAllParentheses(new char[2*n], 0, combinations);
        return combinations;
    }

    private static void generateAllParentheses(char[] arr, int pos, List<String> combinations) {
        if (pos == arr.length) {
            if (isValid(arr)) {
                combinations.add(new String(arr));
                return;
            }
            return;
        }
        arr[pos] = '(';
        generateAllParentheses(arr, pos+1, combinations);
        arr[pos] = ')';
        generateAllParentheses(arr, pos+1, combinations);
    }

    private static boolean isValid(char[] arr) {
        int balance = 0;
        for (char c : arr) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    /**
     * Backtracking approach
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String s = "";
        int open = 0, close = 0;
        generateAll(result,s,open,close,n);
        return result;
    }

    private static void generateAll(List<String> result, String s, int open, int close, int n) {
        // length of the string is 2 * n
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }
        // add opening braces only when if it is less than the available no. of opening braces i.e. n
        if (open < n) {
            generateAll(result, s+"(", open+1, close, n);
        }
        // add closing braces only when if it is less than the no. of opening braces
        if (close < open) {
            generateAll(result, s+")", open, close+1, n);
        }
    }

    public static void main(String[] args)
    {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
