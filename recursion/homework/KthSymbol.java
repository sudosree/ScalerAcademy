package recursion.homework;

public class KthSymbol
{
    private static int solve(int A, int B) {
        String res = helper(A);
        return res.charAt(B-1) - '0';
    }

    private static String helper(int A) {
        if (A == 1) {
            return "0";
        }
        String str = helper(A-1);
        StringBuilder res = new StringBuilder();
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == '0') {
                res.append("01");
            } else {
                res.append("10");
            }
        }
        return res.toString();
    }

    public static void main(String[] args)
    {
        int A = 3, B = 1;
        System.out.println(solve(A,B));
    }
}
