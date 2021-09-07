package arrays.practice;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // copy the first m elements from nums1 into nums1copy
        int[] nums1Copy = new int[m];
        for (int i=0;i<m;i++) {
            nums1Copy[i] = nums1[i];
        }
        int i=0,j=0;
        for (int k=0; k<m+n; k++) {
            if (j == n || (i < m && nums1Copy[i] <= nums2[j])) {
                nums1[k] = nums1Copy[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        for (int k=m+n-1; k>=0; k--) {
            // nothing left to merge
            if (j < 0) {
                break;
            }
            if (i>= 0 && nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }
}
