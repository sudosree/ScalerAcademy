package recursion.practice;

import java.util.*;

public class Combinations
{
    /**
     * TC = O(k * nCk) (where nCk = no. of combinations and k = length of each combination
     * SC = O(
     * @param n
     * @param k
     * @return
     */
    private static List<List<Integer>> combine(int n, int k) {
        List<Integer> choices = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combineHelper(n,k,1,choices,result);
        return result;
    }

    private static void combineHelper(int n, int k, int index, List<Integer> choices, List<List<Integer>> result) {
        if (choices.size() == k) {
            result.add(new ArrayList<>(choices));
            return;
        }
        for (int i=index;i<=n;i++) {
            choices.add(i);
            combineHelper(n,k,i+1,choices,result);
            choices.remove(choices.size()-1);
        }
    }

    public static void main(String[] args)
    {
        int n = 4, k = 2;
        System.out.println(combine(n,k));
    }
}
