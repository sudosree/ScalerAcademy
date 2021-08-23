package string.practice;

public class FindString {

    private static int findStr(String[] input, String s) {
        for (int i=0;i<input.length;i++) {
            String str = input[i];
            if (str.equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] input = {"for", "", "", "", "geeks",
                "ide", "", "practice", "" ,
                "", "quiz", "", ""};
        String s = "quiz";
        System.out.println(findStr(input, s));
    }
}
