package string.practice;

public class StringToInteger {

    public static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int num = 0, index = 0;
        int sign = 1;

        // handle whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        // reached the end of the string
        if (index == n) {
            return 0;
        }
        // handle signs
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        // read non digit letters
        while (index < n) {
            int digit = s.charAt(index) - '0';
            // not a digit
            if (digit < 0 || digit > 9) {
                break;
            }
            // check for overflow
            if (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)) {
                num = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                return num;
            }
            num = 10 * num + digit;
            index++;
        }
        return num * sign;
    }

    public static void main(String[] args) {
        String s = "  -2147483648 poi ";
        System.out.println(myAtoi(s));
    }
}
