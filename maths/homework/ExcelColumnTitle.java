package maths.homework;

public class ExcelColumnTitle
{
    private static String convertToTitle(int A) {
        StringBuilder s = new StringBuilder();
        while (A > 0) {
            A -= 1;
            int rem = A%26;
            s.append((char)('A' + rem));
            A /= 26;
        }
        return s.reverse().toString();
    }

    public static void main(String[] args)
    {
        int A = 27;
        System.out.println(convertToTitle(A));
    }
}
