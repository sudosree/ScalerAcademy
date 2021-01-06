package maths;

public class ExcelColumnNumber
{
    private static int titleToNumber(String A) {
        int num = 0;
        for (int i=A.length()-1,j=0; i>=0; i--,j++) {
            int c = (A.charAt(i) - 'A') + 1;
            num += (c * (int)Math.pow(26,j));
        }
        return num;
    }

    public static void main(String[] args)
    {
        String A = "ABCD";
        System.out.println(titleToNumber(A));
    }
}
