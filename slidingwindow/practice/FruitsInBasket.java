package slidingwindow.practice;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {

    private static int fruitsIntoBasket(char[] nums) {
        int n = nums.length, left = 0, right = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int unique = 0;	// keep track of the no. of distinct characters
        int maxFruits = 0;	// max no. of fruits
        int count = 0; // no. of fruits
        while (right < n) {
            char r = nums[right];
            count++;
            if (!freq.containsKey(r)) {
                unique++;
            }
            freq.put(r, freq.getOrDefault(r, 0) + 1);
            while (unique > 2) {
                char l = nums[left];
                freq.put(l, freq.get(l) - 1);
                if (freq.get(l) == 0) {
                    unique--;
                    freq.remove(l);
                }
                count--;
                left++;
            }
            maxFruits = Math.max(maxFruits, count);
            right++;
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        char[] nums = {'A', 'A', 'A', 'B', 'C', 'B', 'B', 'C', 'A', 'A', 'D'};
        System.out.println(fruitsIntoBasket(nums));
    }
}
