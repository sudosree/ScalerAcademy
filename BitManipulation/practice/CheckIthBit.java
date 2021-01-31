package BitManipulation.practice;

public class CheckIthBit
{
    private static boolean checkIthBitSet(int A, int i) {
        return ((A >> i) & 1) == 1;
    }

    public static void main(String[] args)
    {
        int A = 182, i = 5;
        System.out.println(checkIthBitSet(A,i));
    }
}
