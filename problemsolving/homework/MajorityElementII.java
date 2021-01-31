package problemsolving.homework;

import java.util.*;

public class MajorityElementII
{
    public static int repeatedNumber(final List<Integer> a) {
        int candidate1 = -1, candidate2 = -1;
        int count1 = 0, count2 = 0;

        for (int i=0;i<a.size();i++) {
            int num = a.get(i);
            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            } else if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        // second pass
        // check if the frequency of the majority elements are more than n/3 or not
        int m1 = 0, m2 = 0;
        for (int i=0;i<a.size();i++) {
            if (candidate1 != -1 && a.get(i).equals(candidate1)) {
                m1++;
            }
            if (candidate2 != -1 && a.get(i).equals(candidate2)) {
                m2++;
            }
        }
        if (m1 > a.size()/3) {
            return candidate1;
        }
        if (m2 > a.size()/3) {
            return candidate2;
        }
        return -1;
    }

    public static List<Integer> repeatedNumber1(int[] nums) {
        Integer candidate1 = null, candidate2 = null;
        int count1 = 0, count2 = 0;

        for (int i=0;i<nums.length;i++) {
            if (candidate1 != null && nums[i] == candidate1) {
                count1++;
            } else if (candidate2 != null && nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // check if the frequency of the majority elements are more than n/3 or not
        int m1 = 0, m2 = 0;
        for (int i=0;i<nums.length;i++) {
            if (candidate1 != null && nums[i] == candidate1) {
                m1++;
            }
            if (candidate2 != null && nums[i] == candidate2) {
                m2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (m1 > nums.length/3) {
            res.add(candidate1);
        }
        if (m2 > nums.length/3) {
            res.add(candidate2);
        }
        return res;
    }

    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1,2,2,3,1,1,1,2,2);
        int[] nums = {3,2,3};
        System.out.println(repeatedNumber1(nums));
    }
}
