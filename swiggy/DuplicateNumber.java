package swiggy;

public class DuplicateNumber {
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
}
