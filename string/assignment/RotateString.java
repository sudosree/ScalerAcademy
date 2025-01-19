package string.assignment;

public class RotateString
{
    private static String solve(String A, int B) {
        int n = A.length();
        B = B%n;
        char[] ch = A.toCharArray();
        char[] res = new char[n];
        for (int i=0;i<n;i++) {
            res[i] = ch[(n-B+i)%n];
        }
        return new String(res);
    }

    private static String solve1(String A, int B) {
        int n = A.length();
        char[] ch = A.toCharArray();
        B = B%n;
        // reverse the whole string
        reverse(ch, 0, n-1);
        // reverse the first B characters
        reverse(ch, 0, B-1);
        // reverse the last n-B characters
        reverse(ch, B, n-1);
        return new String(ch);
    }

    private static void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char t = ch[start];
            ch[start++] = ch[end];
            ch[end--] = t;
        }
    }

    public boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }
        int n = s.length();
        char[] ch = s.toCharArray();
        // rotate the string at most n times
        // keep on rotating the string s untill it becomes equal to goal
        // after each rotation check if the rotated string is equal to the goal then return
        // true else return false
        for (int i=1; i<n; i++) {
            char prev = ch[n-1];
            for (int j=0; j<n; j++) {
                char t = ch[j];
                ch[j] = prev;
                prev = t;
            }
            String t = String.valueOf(ch);
            if (t.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public boolean rotateString1(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            return true;
        }
        int n = s.length();
        for (int rotation=1; rotation<n; rotation++) {
            if (rotateString(s, goal, rotation)) {
                return true;
            }
        }
        return false;
    }

    private boolean rotateString(String A, String B, int rotation) {
        int n = A.length();
        for (int i=0; i<n; i++) {
            if (A.charAt(i) != B.charAt((i + rotation) % n)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        String A = "scaler";
        int B = 2;
        System.out.println(solve1(A,B));
    }
}
