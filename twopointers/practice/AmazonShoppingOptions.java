package twopointers.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AmazonShoppingOptions {

    private static int getNumberOfOptions (int[] jeans, int[] shoes, int[] skirts, int[] tops, int budget) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i=0;i<jeans.length;i++) {
            for (int j=0;j<shoes.length;j++) {
                int sum = jeans[i] + shoes[j];
                freq.put(sum, freq.getOrDefault(sum, 0)+1);
            }
        }
        int count = 0;
        for (int i=0;i<skirts.length;i++) {
            for (int j=0;j<tops.length;j++) {
                int find = budget - (skirts[i] + tops[j]);
                for (int key : freq.keySet()) {
                    if (key <= find) {
                        count += freq.get(key);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] jeans = {8,1};
        int[] shoes = {2};
        int[] skirts = {2,5};
        int[] tops = {4,2};
        int budget = 15;
        System.out.println(getNumberOfOptions(jeans, shoes, skirts, tops, budget));
    }
}
