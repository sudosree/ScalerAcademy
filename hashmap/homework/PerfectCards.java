package hashmap.homework;

import java.util.*;

/**
 * Problem Description
 *
 * Tom and Harry are given N numbers, with which they play a game as a team.
 *
 * Initially, Tom chooses a particular number P from the N numbers, and he takes away all the numbers that are equal to P.
 *
 * Next, Harry chooses a different number Q, different from what Tom chose, and takes away all the numbers equal to Q from the remaining N numbers.
 *
 * They win the game if they can take all the numbers by doing the above operation once and if each of them has the same amount of numbers towards the end.
 *
 * If they win, return the string "WIN", else return "LOSE".
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 100
 *
 * 1 <= A[i] <= 100
 *
 *
 *
 * Input Format
 *
 * The first and the only argument of input contains an integer array, A.
 *
 *
 * Output Format
 *
 * Return a string, denoting the answer.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2]
 *
 * Input 2:
 *
 *  A = [1, 1, 2, 2, 3]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  "WIN"
 *
 * Output 2:
 *
 *  "LOSE"
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  In the his turn, Tom can take 1 away, and then Harry take take 2 away. The array is empty and both of them have equal number of cards, so we can say that they have won the game.
 *
 * Explanation 2:
 *
 *  No matter how they take away the elements, >= 1 card will always remain, hence, they lose.
 */
public class PerfectCards
{
    private static String solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        if (map.size() > 2) {
            return "LOSE";
        }
        int p = A[0];
        int tom = map.get(p), harry = 0;
        map.put(p,0);   // set the count to 0
        for (int i=1;i<A.length;i++) {
            // no. chosen by harry
            int q = A[i];
            if (p != q) {
                harry = map.get(q);
                map.put(q,0);
                break;
            }
        }
        return tom == harry ? "WIN" : "LOSE";
    }

    public static void main(String[] args)
    {
        int[] A = {1, 1, 1, 2, 2,2};
        System.out.println(solve(A));
    }
}
