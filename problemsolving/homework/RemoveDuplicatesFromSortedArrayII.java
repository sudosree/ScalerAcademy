package problemsolving.homework;

import java.util.*;

/**
 * Remove Duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 *
 * For example, Given input array A = [1,1,1,2],
 *
 * Your function should return length = 3, and A is now [1,1,2].
 */
public class RemoveDuplicatesFromSortedArrayII
{
    public static int[] removeDuplicates(int[] nums) {
        int count = 1, i = 0;
        for (int j=1;j<nums.length;j++) {
            if (nums[i] == nums[j]) {
                count++;
                nums[i+1] = nums[j];
                if (count <= 2) {
                    i++;
                }
            } else {
                count = 1;
                nums[i+1] = nums[j];
                i++;
            }
        }
        return nums;
//        return i+1;
    }

    public static void main(String[] args)
    {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }
}
