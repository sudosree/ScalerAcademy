package greedy.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {

    private static Map<Integer, String> map = new LinkedHashMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int smallNum = 0;
            for (int n : map.keySet()) {
                if (n <= num) {
                    smallNum = n;
                    break;
                }
            }
            String s = map.get(smallNum);
            // check how many times it can fit
            int fit = num/smallNum;
            for (int i=0;i<fit;i++) {
                sb.append(s);
            }
            num -= (smallNum * fit);
        }

        return sb.toString();
    }
}
