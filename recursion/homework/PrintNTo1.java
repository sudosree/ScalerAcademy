package recursion.homework;

import java.util.*;

public class PrintNTo1
{
    private static void print(int num) {
        if (num == 0) {
            return;
        }
        System.out.print(num + " ");
        print(num-1);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        print(num);
    }
}
