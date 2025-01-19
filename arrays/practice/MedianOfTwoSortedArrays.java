package arrays.practice;

public class MedianOfTwoSortedArrays {

  private static int p1 = 0, p2 = 0;

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    // if the no. of elements are even
    if ((m + n) % 2 == 0) {
      for (int i = 0; i < (m+n)/2 - 1; i++) {
        getMin(nums1, nums2);
      }
      return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
    }
    // if the no. of elements are odd
    else {
      for (int i = 0; i < (m+n) / 2; i++) {
        getMin(nums1, nums2);
      }
      return getMin(nums1, nums2);
    }
  }

  private static int getMin(int[] nums1, int[] nums2) {
    if (p1 < nums1.length && p2 < nums2.length) {
      return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
    } else if (p1 < nums1.length) {
      return nums1[p1++];
    } else if (p2 < nums2.length) {
      return nums2[p2++];
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums1 = {5,7,9,10};
    int[] nums2 = {1,2,3,4,6,8,11};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }
}
