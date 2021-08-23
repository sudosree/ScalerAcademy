package string.practice;

public class FindNeedleInHaystack {

    private int strStr(String haystack, String needle) {
        // if the needle is empty then return 0
        if (needle.length() == 0) {
            return 0;
        }
        // if the length of haystack is less than needle's length return -1
        // you cannot find needle in haystack
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i=0;i<haystack.length();i++) {
            int hIdx = i;
            int nIdx = 0;
            while (hIdx < haystack.length() && nIdx < needle.length() && haystack.charAt(hIdx) == needle.charAt(nIdx)) {
                hIdx++;
                nIdx++;
            }
            // when you find needle in haystack
            if (nIdx == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr1(String haystack, String needle) {
        // if the needle is empty then return 0
        if (needle.length() == 0) {
            return 0;
        }
        // if the haystack length is 0 then return -1
        if (haystack.length() == 0) {
            return -1;
        }

        for (int i=0;i<haystack.length();i++) {
            for (int j=0;j<needle.length();j++) {
                // no enough places for needle after i
                if (i + needle.length() > haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i+j)) {
                    break;
                }
                if (j == needle.length()-1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issipi";
        System.out.println(strStr1(haystack, needle));
    }
}
