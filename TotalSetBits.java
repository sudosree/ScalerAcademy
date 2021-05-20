public class TotalSetBits {

    private static int totalSetBits(int num) {
        num = num + 1;
        int currBitPos = 1;
        int setBitCount = num/2;
        while ((1 << currBitPos) <= num) {
            int groupOfZeroesOnes = num/(1 << currBitPos);
            int groupOfOnes = groupOfZeroesOnes/2;
            setBitCount += groupOfOnes * (1 << currBitPos);
            // for extra set bit in case of odd no. of groups
            setBitCount += (groupOfZeroesOnes & 1) == 1 ? num % (1 << currBitPos) : 0;
            currBitPos++;
        }
        return setBitCount;
    }

    public static void main(String[] args) {
        System.out.println(totalSetBits(14));
    }
}
