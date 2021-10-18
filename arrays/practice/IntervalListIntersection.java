package arrays.practice;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length, n = secondList.length;
        if (m == 0 || n == 0) {
            return new int[][]{};
        }
        List<int[]> res = new ArrayList<>();
        for (int i=0; i<m; i++) {
            int[] first = firstList[i];
            for (int j=0; j<n; j++) {
                int[] second = secondList[j];
                // check if there is an overlapp or not
                // if there is an overlapp add the intersection interval
                // in the list
                if (second[0] <= first[1] && second[1] >= first[0]) {
                    int start = Math.max(first[0], second[0]);
                    int end = Math.min(first[1], second[1]);
                    res.add(new int[]{start, end});
                }
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public int[][] intervalIntersection1(int[][] firstList, int[][] secondList) {
        int m = firstList.length, n = secondList.length;
        if (m == 0 || n == 0) {
            return new int[][]{};
        }
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < m && j < n) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            // check if there is an overlapp or not
            if (second[0] <= first[1] && second[1] >= first[0]) {
                int start = Math.max(first[0], second[0]);
                int end = Math.min(first[1], second[1]);
                res.add(new int[]{start, end});
            }
            // you have exhaust the first interval move to the next interval
            if (first[1] <= second[1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int k=0; k<res.size(); k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }
}
