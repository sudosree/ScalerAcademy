package string.practice;

public class ValidIP {

    public static String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return checkIPV4(IP) ? "IPv4" : "Neither";
        }
        if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return checkIPV6(IP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    private static boolean checkIPV4(String ip) {
        String[] str = ip.split("\\.", -1);
        for (int i=0; i<str.length; i++) {
            String s = str[i];
            // if the length of a string is > 3 then it is invalid
            if (s.length() == 0 || s.length() > 3) {
                return false;
            }
            // if there is a leading 0 or not
            if (s.charAt(0) == '0' && s.length() > 1) {
                return false;
            }
            // if the character is not digit
            for (char ch : s.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }
            // if the value is > 255
            if (Integer.parseInt(s) > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIPV6(String ip) {
        String[] str = ip.split("\\:", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (int i=0; i<str.length; i++) {
            String s = str[i];
            if (s.length() == 0 || s.length() > 4) {
                return false;
            }
            for (char ch : s.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String IP = "1.0.1.";
        System.out.println(validIPAddress(IP));
    }
}
