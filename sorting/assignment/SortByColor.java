package sorting.assignment;

import java.util.*;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: Using library sort function is not allowed.
 *
 * Example :
 *
 * Input : [0 1 2 0 1 2]
 * Modify array so that it becomes : [0 0 1 1 2 2]
 */
public class SortByColor
{

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static void sortColors(ArrayList<Integer> a) {
        int[] freq = new int[3];
        for (int n : a) {
            freq[n]++;
        }
        int i=0;
        for (int j=0; i<a.size() && j<freq[0]; i++,j++) {
            a.set(i,0);
        }
        for (int j=0; i<a.size() && j<freq[1]; i++,j++) {
            a.set(i,1);
        }
        for (int j=0; i<a.size() && j<freq[2]; i++,j++) {
            a.set(i,2);
        }
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    private static void solve(ArrayList<Integer> a) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int n : a) {
            if (n == 0) {
                count0++;
            } else if (n == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        int i=0;
        for (int j=0; i<a.size() && j<count0; i++,j++) {
            a.set(i,0);
        }
        for (int j=0; i<a.size() && j<count1; i++,j++) {
            a.set(i,1);
        }
        for (int j=0; i<a.size() && j<count2; i++,j++) {
            a.set(i,2);
        }
    }

    private static void sortColors(int[] a) {
        int[] freq = new int[3];
        for (int n : a) {
            freq[n]++;
        }
        int i=0;
        for (int j=0; i<a.length && j<freq[0]; i++,j++) {
            a[i] = 0;
        }
        for (int j=0; i<a.length && j<freq[1]; i++,j++) {
            a[i] = 1;
        }
        for (int j=0; i<a.length && j<freq[2]; i++,j++) {
            a[i] = 2;
        }
    }

    public void sortColors1(int[] nums) {
        // p0 will track the rightmost boundary of 0s
        int p0 = 0;
        // p2 will track the leftmost boundary of 2s
        int p2 = nums.length-1;
        int curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                int t = nums[curr];
                nums[curr] = nums[p0];
                nums[p0] = t;
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                int t = nums[curr];
                nums[curr] = nums[p2];
                nums[p2] = t;
                p2--;
            } else {
                curr++;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] A = {0, 1, 2, 0, 0, 0, 1, 1, 2};
        sortColors(A);
        for (int i=0;i<A.length;i++) {
            System.out.println(A[i]);
        }
    }
}
