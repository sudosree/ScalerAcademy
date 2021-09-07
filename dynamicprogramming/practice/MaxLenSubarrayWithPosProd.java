package dynamicprogramming.practice;

public class MaxLenSubarrayWithPosProd {

    public int getMaxLen(int[] nums) {
        // to keep track of the first negative integer, incase if there are odd no.s of
        // negative integers we can remove the leftmost negative integer with this index
        int firstNegPos = -1;
        // to keep track of the zero positions
        int zeroPos = -1;
        // to keep track of the no. of negative integers
        int negCount = 0;
        int maxLen = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] < 0) {
                // increment the negative count
                negCount++;
                // if it is the first negative integer
                if (firstNegPos == -1) {
                    firstNegPos = i;
                }
            }
            // if the no. is zero then we cannot consider the no.s from 0 to i as the product of
            // all of them will give us zero, so reset everything
            if (nums[i] == 0) {
                zeroPos = i;
                firstNegPos = -1;
                negCount = 0;
            }
            // check if the no. of negative integers are even or odd
            else {
                // either all the integers are positive or there are even no.
                // of negative integers
                if (negCount % 2 == 0) {
                    maxLen = Math.max(maxLen, i - zeroPos);
                }
                // there are odd no. of negative integers we have to remove the leftmost
                // negative integer
                else {
                    maxLen = Math.max(maxLen, i - firstNegPos);
                }
            }
        }
        return maxLen;
    }
}
