package arrays.practice;

public class MakeArrayElementsEqualToZero {

  public static int countValidSelections(int[] nums) {
    int validSelections = 0;
    int n = nums.length;
    int[] copy = new int[n];
    copyArray(nums, copy);
    for (int i=0; i<n; i++) {
      if (nums[i] == 0) {
        int curr = i;
        boolean left = true;
        // start by moving in the left direction
        while (curr >= 0 && curr < n) {
          if (nums[curr] > 0) {
            nums[curr]--;
            left = !left;
          }
          if (left) {
            curr--;
          } else {
            curr++;
          }
        }
        // check if all the elements becomes 0
        if (checkAllNosZero(nums)) {
          validSelections++;
        }
        // revert the changes
        copyArray(copy, nums);
        left = false;
        curr = i;
        // start by moving in the right direction
        while (curr >= 0 && curr < n) {
          if (nums[curr] > 0) {
            nums[curr]--;
            left = !left;
          }
          if (left) {
            curr--;
          } else {
            curr++;
          }
        }
        // check if all the elements becomes 0
        if (checkAllNosZero(nums)) {
          validSelections++;
        }
        // revert the changes
        copyArray(copy, nums);
      }
    }
    return validSelections;
  }

  private static void copyArray(int[] nums, int[] copy) {
    for (int i=0; i<nums.length; i++) {
      copy[i] = nums[i];
    }
  }

  private static boolean checkAllNosZero(int[] nums) {
    for (int i=0; i<nums.length; i++) {
      if (nums[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public int countValidSelections1(int[] nums) {
    int validSelections = 0;
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];
    for (int i=1; i<n; i++) {
      left[i] = left[i-1] + nums[i-1];
    }
    for (int i=n-2; i>=0; i--) {
      right[i] = right[i+1] + nums[i+1];
    }
    for (int i=0; i<n; i++) {
      if (nums[i] == 0) {
        if (left[i] == right[i]) {
          validSelections += 2;
        } else if (Math.abs(left[i] - right[i]) == 1) {
          validSelections += 1;
        }
      }
    }
    return validSelections;
  }

  public static void main(String[] args) {
    int[] nums = {2,3,4,0,4,1,0};
    System.out.println(countValidSelections(nums));
  }
}
