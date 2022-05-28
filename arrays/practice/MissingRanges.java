package arrays.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingRanges {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        int num = lower;
        while (num <= upper) {
            if (set.contains(num)) {
                num++;
                continue;
            }
            int left = num;
            int temp = num+1;
            while (!set.contains(temp)) {
                temp++;
            }
            int right = temp-1;
            if (left == right) {
                sb.append(String.valueOf(left));
            } else {
                sb.append(String.valueOf(left)).append("->").append(String.valueOf(right));
            }
            sb.append(",");
            num = temp+1;
        }
        sb.deleteCharAt(sb.length()-1);
        ans.add(sb.toString());
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0, upper = 99;
        System.out.println(findMissingRanges(nums, lower, upper));
    }
}
