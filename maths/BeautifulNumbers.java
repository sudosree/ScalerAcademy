package maths;

public class BeautifulNumbers {

    static long solve(int l, int r){
        // Your code goes here
        long sum = 0;
        for (int i=l;i<=r;i++) {
            boolean beautiful_no = isBeautiful(i);
            if (beautiful_no) {
                sum += i;
            }
        }
        return sum;
    }

    static boolean isBeautiful(int num) {
        long n = num;
        while (n != 1) {
            long t = calculate(n);
            if (t == 1) {
                return true;
            }
            if (t > 1 && t < 10) {
                break;
            }
            n = t;
        }
        return false;
    }

    static long calculate(long num) {
        int sum = 0;
        while (num > 0) {
            long rem = num%10;
            num /= 10;
            sum += rem * rem;
        }
        return sum;
    }

    public static void main(String[] args) {
        int l = 21, r = 30;
        System.out.println(solve(l,r));
    }
}
