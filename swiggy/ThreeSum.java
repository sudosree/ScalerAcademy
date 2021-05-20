package swiggy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {

    private static void findTriplet(int[] A, int sum) {
        // a+b+c = sum, fix a and for each a find pair b & c such that b+c = sum-a
        Arrays.sort(A);
        for (int i=0;i<A.length-1;i++) {
            int left = i+1, right = A.length-1;
            while (left < right) {
                if (A[left] + A[right] == sum - A[i]) {
                    System.out.println(A[i] + " " + A[left] + " " + A[right]);
                    return;
                }
                if (A[left] + A[right] < sum - A[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    private static void findTriplet1(int[] A, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<A.length-1;i++) {
            int sumToFind = sum - A[i];
            for (int j=i+1;j<A.length;j++) {
                if (map.containsKey(sumToFind - A[j])) {
                    System.out.println(A[i] + " " + A[j] + " " + (sumToFind - A[j]));
                    return;
                }
                map.put(A[j], j);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {12, 3, 4, 1, 6, 9};
        findTriplet(A, 24);
        findTriplet1(A, 24);
    }
}
