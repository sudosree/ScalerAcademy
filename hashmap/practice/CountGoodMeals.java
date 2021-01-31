package hashmap.practice;

import java.util.*;

public class CountGoodMeals
{
    public static int countPairs(int[] deliciousness) {
        int count = 0;
        for (int i=0;i<deliciousness.length-1;i++) {
            for (int j=i+1;j<deliciousness.length;j++) {
                if (checkPowerOf2(deliciousness[i] + deliciousness[j])) {
                    count = (count + 1) % 1000000007;
                }
            }
        }
        return count;
    }

    private static int countPairs1(int[] deliciousness) {
        int mod = 1000000007;
        Map<Integer,Integer> freq = new HashMap<>();
        for (int i=0;i<deliciousness.length;i++) {
            freq.put(deliciousness[i], freq.getOrDefault(deliciousness[i], 0) + 1);
        }
        long count = 0;
        for (int num : freq.keySet()) {
            if (num == 0) {
                continue;
            }
            int power = num;
            // if num is a power of 2
            if ((num & (num - 1)) == 0) {
                int f = freq.get(num);
                // the no. of pairs will be (n * (n-1))/2
                int pairs = ((f * (f-1))/2) % mod;
                count += pairs;
                count %= mod;
            }
            // if num is not a power of 2
            else {
                // find the next power of 2
                int t = num;
                power = 1;
                while (t > 0) {
                    power = power << 1;
                    t /= 2;
                }
            }
            // this part is required for both the case if num is a power of 2 and if num is not a power of 2
            // if num is not a power of 2, this case is simple
            // if num is a power of 2 then diff == 0 and if diff present in the map then num and diff will form
            // a pair depending on the counts of num and diff
            int diff = power - num;
            if (freq.containsKey(diff)) {
                int pairs = (freq.get(num) * freq.get(diff)) % mod;
                count += pairs;
                count %= mod;
            }
        }
        return (int)count;
    }

    private static boolean checkPowerOf2(int n) {
        return n != 0 && ((n & (n-1)) == 0);
    }

    private static int nextPowerOf2(int n) {
        int power = 1;
        while (n > 0) {
            power = power << 1;
            n >>= 1;
        }
        return power;
    }

    public static void main(String[] args)
    {
        int[] A = {32,32,32,32,32};
        System.out.println(countPairs1(A));
    }
}
