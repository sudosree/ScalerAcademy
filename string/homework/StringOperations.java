package string.homework;

public class StringOperations
{
    private static String solve(String A) {
        String s = A + A;
        char[] ch = s.toCharArray();
        int i=0;
        for (int j=0;j<ch.length;j++) {
            // ignore the uppercase character
            if (ch[j] >= 'A' && ch[j] <= 'Z') {
                continue;
            }
            // replace the vowels with #
            else if (ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u'){
                ch[i++] = '#';
            } else {
                ch[i++] = ch[j];
            }
        }
        return new String(ch).substring(0,i);
    }

    public static void main(String[] args)
    {
        String A = "AbcaZeoB";
        System.out.println(solve(A));
    }
}
