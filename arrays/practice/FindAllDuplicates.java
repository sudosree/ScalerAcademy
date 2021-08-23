package arrays.practice;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        // negate the no. nums[i] at index nums[nums[i] - 1]
        for (int i=0;i<nums.length;i++) {
            nums[Math.abs(nums[i]) - 1] *= -1;
        }

        List<Integer> ans = new ArrayList<>();
        // if a no. nums[i] has appeared twice then it will be negated twice
        // and the value at index nums[nums[i] - 1] will be positive
        for (int i=0;i<nums.length;i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                ans.add(Math.abs(nums[i]));
                // again negate it so that when the second occurrence of this no. comes you do not
                // repeat the same thing
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return ans;
    }
}
