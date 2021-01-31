package maths.practice;

import java.util.*;

public class FindSubsequencesWithGCDOne
{
    private static boolean solve(int[] A) {
        List<Integer> choices = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        findSubsequencesOfLen2(A, 0, choices, result);
        for (int i=0;i<result.size();i++) {
            if (result.get(i).size() == 2) {
                List<Integer> list = result.get(i);
                int gcd = findGCD(list.get(0), list.get(1));
                if (gcd == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void findSubsequencesOfLen2(int[] A, int index, List<Integer> choices, List<List<Integer>> result) {
        for (int i=index;i<A.length;i++) {
            choices.add(A[i]);
            if (choices.size() == 2) {
                result.add(new ArrayList<>(choices));
            }
            findSubsequencesOfLen2(A, i+1, choices, result);
            choices.remove(choices.size()-1);
        }
    }

    private static int findGCD(int A, int B) {
        if (A == 0) {
            return B;
        }
        if (B == 0) {
            return A;
        }
        if (B > A) {
            // swap B and A
            int t = A;
            A = B;
            B = t;
        }
        int diff = A - B;
        while (diff != 0) {
            if (diff > B) {
                A = diff;
            } else {
                A = B;
                B = diff;
            }
            diff = A - B;
        }
        return A;
    }

    public static void main(String[] args)
    {
        int[] A = {2,3,4,5,6,7,8};
        System.out.println(solve(A));
    }
}
