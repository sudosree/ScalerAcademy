package recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSumHelper(0, candidates, target, list, ans);
        return ans;
    }

    private void combinationSumHelper(int index, int[] candidates, int target, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i=index;i<candidates.length;i++) {
            if (candidates[i] <= target) {
                target -= candidates[i];
                list.add(candidates[i]);
                combinationSumHelper(i, candidates, target, list, ans);
                target += candidates[i];
                list.remove(list.size()-1);
            }
        }
    }
}
