package recursion.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        combinationSumHelper(0, candidates, target, comb, ans);
        return ans;
    }

    private void combinationSumHelper(int index, int[] candidates, int target, List<Integer> comb, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (candidates[i] <= target) {
                target -= candidates[i];
                comb.add(candidates[i]);
                combinationSumHelper(i+1, candidates, target, comb, ans);
                comb.remove(comb.size() - 1);
                target += candidates[i];
            }
        }
    }
}
