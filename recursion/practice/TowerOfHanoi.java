package recursion.practice;

public class TowerOfHanoi
{
    enum Tower {
        Source("S"),
        Temp("T"),
        Destination("D");

        private String value;

        Tower(String value) {
            this.value = value;
        }
    }

    private static void towerOfHanoiHelper(int n, Tower src, Tower temp, Tower dest) {
        if (n == 1) {
            System.out.println("Move disc " + n + " from source: " + src.value + " to " + " destination: " + dest.value + " using temp: " + temp.value);
            return;
        }
        towerOfHanoiHelper(n-1,src,dest,temp);
        System.out.println("Move disc " + n + " from source: " + src.value + " to " + " destination: " + dest.value + " using temp: " + temp.value);
        towerOfHanoiHelper(n-1,temp,src,dest);
    }

    private static void towerOfHanoi(int n) {
        towerOfHanoiHelper(n, Tower.Source, Tower.Temp, Tower.Destination);
    }

    public static void main(String[] args)
    {
        int n = 3;
        towerOfHanoi(n);
    }
}
