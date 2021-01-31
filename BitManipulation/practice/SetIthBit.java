package BitManipulation.practice;

public class SetIthBit
{
    private static int setIthBit(int A, int i) {
        return (A >> i) | 1;
    }

    public static void main(String[] args)
    {
        int A = 8, i = 2;
        System.out.println(setIthBit(A,i));
    }
}
