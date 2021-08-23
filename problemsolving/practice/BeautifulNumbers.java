package problemsolving.practice;

public class BeautifulNumbers {

    private static boolean isBeautiful(int n) {
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

    private static long beautifulNumbers(int l, int r) {
        long sum = 0;
        for (int i=l;i<=r;i++) {
            if (isBeautiful(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private static long[] memo;

    private static long beautifulNumbers1(int l, int r) {
        memo = new long[1000005];
        for (int i=1;i<=1000000;i++) {
            if (isBeautiful(i)) {
                memo[i] = i;
            }
        }
        for (int i=1;i<=1000000;i++) {
            memo[i] += memo[i-1];
        }
        return memo[r] - memo[l-1];
    }

    public static void main(String[] args) {
        int l = 31, r = 32;
        System.out.println(beautifulNumbers(l, r));
        System.out.println(beautifulNumbers1(l, r));
    }
}
