package maths.homework;

public class ExcelSheetColNo {

    public int titleToNumber(String columnTitle) {
        int ans = 0, n = columnTitle.length();
        int pow = 0;
        for (int i=n-1; i>=0; i--) {
            int num = (int)((columnTitle.charAt(i) - 'A') + 1);
            ans += (num * Math.pow(26, pow));
            pow++;
        }
        return ans;
    }
}
