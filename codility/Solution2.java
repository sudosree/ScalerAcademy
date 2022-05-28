package codility;

public class Solution2 {
    public static int solution(int A, int B) {
        // write your code in Java SE 8
        long prod = A * B;
        int count = 0;
        while (prod > 0) {
            prod = prod & (prod - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int A = 5, B = 6;
        System.out.println(solution(A, B));
    }
}
