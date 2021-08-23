package problemsolving.practice;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);

        }
        return n == 1;
    }

    public static boolean isHappy1(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private static int getNext(int num) {
        int n = 0;
        while (num > 0) {
            int rem = num%10;
            num = num/10;
            n += (long)(rem * rem);
        }
        return n;
    }
}
