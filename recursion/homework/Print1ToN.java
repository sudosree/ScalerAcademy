package recursion.homework;

public class Print1ToN
{
    private static void print(int num) {
        if (num == 0) {
            return;
        }
        print(num-1);
        System.out.print(num + " ");
    }

    public static void main(String[] args)
    {
        /*Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();*/
        int num = 10;
        print(num);
    }
}
