package problemsolving.practice;

public class RemoveDuplicatesFromSortedArray
{
    public static int removeDuplicates(int[] nums) {
        int unique = 0;
        for (int curr=1;curr<nums.length;curr++) {
            if (nums[curr] != nums[unique]) {
                unique++;
                nums[unique] = nums[curr];
            }
        }
        return unique+1;
    }

    public static void main(String[] args)
    {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
