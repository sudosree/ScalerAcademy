package hashmap.homework;

import java.util.HashSet;
import java.util.Set;

public class Colorful {

    private static int colorful(int A) {
        Set<Integer> set = new HashSet<>();
        String s = String.valueOf(A);
        for (int i=0;i<s.length();i++) {
            int prod = 1;
            for (int j=i;j<s.length();j++) {
                prod = prod * Integer.parseInt("" + s.charAt(j));
                if (!set.add(prod)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int A = 236;
        System.out.println(colorful(A));
    }
}
