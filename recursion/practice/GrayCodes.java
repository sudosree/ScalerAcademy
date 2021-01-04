package recursion.practice;

import java.util.*;

public class GrayCodes
{
    private static List<String> grayCodes(int n) {
        // base case
        if (n == 0) {
            return new ArrayList<>(Collections.singletonList("0"));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0","1"));
        }
        List<String> list = grayCodes(n-1);
        List<String> res = new ArrayList<>(list);
        // add the elements in list in reverse order
        for (int i=list.size()-1;i>=0;i--) {
            res.add(list.get(i));
        }
        for (int i=0;i<res.size();i++) {
            String s = res.get(i);
            int pow = (int)Math.pow(2,n);
            // for the first pow/2-1 elements append 0 at the beginning
            if (i<pow/2) {
                s = "0" + s;
            }
            // and for the rest pow/2 to pow-1 append 1 at the beginning
            else {
                s = "1" + s;
            }
            res.set(i,s);
        }
        return res;
    }

    private static List<String> grayCodes1(int n) {
        // base case
        if (n == 0) {
            return new ArrayList<>(Collections.singletonList("0"));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0","1"));
        }
        List<String> list = grayCodes1(n-1);
        List<String> res = new ArrayList<>();
        // append 0 at the beginning
        for (int i=0;i<list.size();i++) {
            res.add("0" + list.get(i));
        }
        // start iterating from the reverse direction and append 1 at the beginning
        for (int i=list.size()-1;i>=0;i--) {
            res.add("1" + list.get(i));
        }
        return res;
    }

    private static List<String> grayCodes2(int n) {
        if (n == 0) {
            return new ArrayList<>(Collections.singletonList("0"));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1"));
        }
        List<String> list = new ArrayList<>(Arrays.asList("0","1"));
        for (int i=2; i<(1<<n); i=i<<1) {
            // copy all the gray codes from list in reverse direction and add it to the same list
            // now the list will have double the previous no. of gray codes
            for (int j=list.size()-1;j>=0;j--) {
                list.add(list.get(j));
            }
            // append 0 at the first position for the first half
            for (int j=0;j<i;j++) {
                list.set(j, "0" + list.get(j));
            }
            // append 1 at the first position for the 2nd half
            for (int j=i;j<2*i;j++) {
                list.set(j, "1" + list.get(j));
            }
        }
        return list;
    }

    public static void main(String[] args)
    {
        int n = 4;
        System.out.println(grayCodes2(n));
    }
}
