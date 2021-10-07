package greedy.practice;

import java.util.Arrays;

public class MaxPlatformNeeded {

    private static int findMaxPlatform(int n, int[] arr, int[] dept) {
        Arrays.sort(arr);
        Arrays.sort(dept);
        int i = 1;	// will keep track of the arrival time
        int j = 0;	// will keep track of the departure time
        int maxPlat = 1, currPlat = 1;

        while (i < n && j < n) {
            // if the arrival time is less than the departure time then
            // the train has to wait so you need one more platform
            if (arr[i] <= dept[j]) {
                currPlat++;
                i++;
            }
            // the train doesn't need to wait
            else {
                currPlat--;
                j++;
            }
            if (currPlat > maxPlat) {
                maxPlat = currPlat;
            }
        }
        return maxPlat;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dept = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findMaxPlatform(6, arr, dept));
    }
}
