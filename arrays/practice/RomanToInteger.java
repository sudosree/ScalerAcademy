package arrays.practice;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    public int romanToInt(String s) {

        int i=0, sum = 0;
        while (i < s.length()) {
            String currSymbol = s.substring(i, i+1);
            int currVal = map.get(currSymbol);
            int nextVal = 0;
            // check if there exists at least 2 characters
            if (i+1 < s.length()) {
                String nextSymbol = s.substring(i+1, i+2);
                nextVal = map.get(nextSymbol);
            }
            if (currVal < nextVal) {
                sum += (nextVal - currVal);
                i += 2;
            } else {
                sum += currVal;
                i += 1;
            }
        }
        return sum;
    }

    static Map<String, Integer> map1 = new HashMap<>();

    static {
        map1.put("I", 1);
        map1.put("V", 5);
        map1.put("X", 10);
        map1.put("L", 50);
        map1.put("C", 100);
        map1.put("D", 500);
        map1.put("M", 1000);

        map1.put("IV", 4);
        map1.put("IX", 9);
        map1.put("XL", 40);
        map1.put("XC", 90);
        map1.put("CD", 400);
        map1.put("CM", 900);
    }

    public int romanToInt1(String s) {

        int i=0, sum = 0;
        while (i < s.length()) {

            // check if there exists at least 2 characters
            if (i < s.length()-1) {
                String nextSymbol = s.substring(i, i+2);
                if (map1.containsKey(nextSymbol)) {
                    sum += map1.get(nextSymbol);
                    i += 2;
                    continue;
                }
            }
            String currSymbol = s.substring(i, i+1);
            sum += map1.get(currSymbol);
            i += 1;
        }
        return sum;
    }
}
