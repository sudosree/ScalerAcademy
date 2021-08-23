package arrays.practice;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNo {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            // treat the value as the index, whenever you are seeing the no nums[i]
            // negate the no at index abs(nums[i]) - 1 to mark the no nums[i] as visited
            int j = Math.abs(nums[i]) - 1;
            // if a no. is already negated then do not negate it again
            if (nums[j] > 0) {
                nums[j] *= -1;
            }
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}
