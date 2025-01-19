package arrays.practice;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int hare = nums[0], tortoise = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        int meeting = tortoise;
        tortoise = nums[0];
        hare = meeting;
        while (hare != tortoise) {
            hare = nums[hare];
            tortoise = nums[tortoise];
        }
        return tortoise;
    }

    public int findDuplicate1(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            int num = Math.abs(nums[i]);
            // mark the no. as negative
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            }
            // you are seeing this no. for the second time
            else {
                return num;
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            while (nums[i] != i+1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    int t = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = t;
                } else {
                    break;
                }
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1) {
                return nums[i];
            }
        }
        return -1;
    }

    public int findDuplicate3(int[] nums) {
        if (nums.length == 1) {
            return -1;
        }
        int tortoise = nums[0];
        int hare = nums[nums[0]];
        while (hare != tortoise) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }
        hare = 0;
        while (hare != tortoise) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }
}
