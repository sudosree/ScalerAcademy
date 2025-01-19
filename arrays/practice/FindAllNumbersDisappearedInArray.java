package arrays.practice;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums.length == 1) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    // whenever you see any no. nums[i] mark the no. nums[i] as seen at index nums[nums[i] - 1]
    for (int i=0; i<nums.length; i++) {
      int num = Math.abs(nums[i]);
      // num is not seen, mark it as seen
      // else if num is already seen then do nothing
      if (nums[num - 1] > 0) {
        nums[num - 1] = -1 * nums[num - 1];
      }
    }

    // check which no. is not seen and return those no.s
    for (int i=1; i<=nums.length; i++) {
      if (nums[i-1] > 0) {
        ans.add(i);
      }
    }
    return ans;
  }
}
