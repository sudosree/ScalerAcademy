package twopointers.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int i=0, j=1;
        while (j < nums.length) {
            if (nums[j] != nums[j-1]) {
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return i+1;
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        int i=0, j=1;
        while (j < a.size()) {
            if (!a.get(j).equals(a.get(j - 1))) {
                a.set(i+1, a.get(j));
                i++;
            }
            j++;
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {5000, 5000, 5000};
        System.out.println(removeDuplicates(nums));
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5000);
        a.add(5000);
        a.add(5000);
        System.out.println(removeDuplicates(a));
    }
}
