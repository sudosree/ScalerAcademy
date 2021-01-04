package hashmap.homework;

import java.util.*;

/**
 * Given a date string in the format Day Month Year, where:
 *
 * Day is in the set {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", ..., "29th", "30th", "31st"}.
 * Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
 * Year is in the inclusive range [1900, 3000].
 *
 * Convert the date string to the format YYYY-MM-DD, where:
 *
 *     YYYY denotes the 4 digit year.
 *     MM denotes the 2 digit month.
 *     DD denotes the 2 digit day.
 *
 * For example:
 *
 * 1st Mar 1984 → 1984-03-01
 * 2nd Feb 2013 → 2013-02-02 4th Apr 1900 → 1900-04-04
 *
 *
 * Input Format
 *
 * The only argument given is a String, a date in the above-mentioned format.
 *
 * Output Format
 *
 * Return a String, i.e date in YYYY-MM-DD format.
 *
 * Constraints
 *
 * The values of Day, Month, and Year are restricted to the value ranges specified above.
 * The given dates are guaranteed to be valid, so no error handling is necessary.
 *
 * Sample Test 1
 *
 * Input:
 *     A = "16th Mar 2068"
 * Output:
 *     2068-03-16
 *
 * Sample Test 2
 *
 * Input:
 *     A = "6th Jun 1933"
 * Output:
 *     1933-06-06
 */
public class ChangeDateFormat
{
    private static String solve(String A) {
        Map<String, String> day = new HashMap<>();
        Map<String, String> month = new HashMap<>();

        day.put("1st", "01");
        day.put("2nd", "02");
        day.put("3rd", "03");
        day.put("4th", "04");
        day.put("5th", "05");
        day.put("6th", "06");
        day.put("7th", "07");
        day.put("8th", "08");
        day.put("9th", "09");
        day.put("10th", "10");
        day.put("11th", "11");
        day.put("12th", "12");
        day.put("13th", "13");
        day.put("14th", "14");
        day.put("15th", "15");
        day.put("16th", "16");
        day.put("17th", "17");
        day.put("18th", "18");
        day.put("19th", "19");
        day.put("20th", "20");
        day.put("21st", "21");
        day.put("22nd", "22");
        day.put("23rd", "23");
        day.put("24th", "24");
        day.put("25th", "25");
        day.put("26th", "26");
        day.put("27th", "27");
        day.put("28th", "28");
        day.put("29th", "29");
        day.put("30th", "30");
        day.put("31st", "31");

        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");

        StringBuilder sb = new StringBuilder();
        String[] s = A.split(" ");
        sb.append(s[2]).append("-");
        sb.append(month.get(s[1])).append("-");
        sb.append(day.get(s[0]));

        return sb.toString();
    }

    public static void main(String[] args)
    {
        String A = "2nd Feb 2013";
        System.out.println(solve(A));
    }
}
