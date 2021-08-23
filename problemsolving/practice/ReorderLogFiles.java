package problemsolving.practice;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

    /**
     * TC = O(m * nlogn) (m = max len of a log, n = no. of logs)
     * SC = O(mlogn)
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new MyComparator());
        return logs;
    }

    private class MyComparator implements Comparator<String> {
        @Override
        public int compare(String log1, String log2) {
            // first split the logs into two parts (identifier, content)
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            // check if the first character of the content is a digit or not
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // case 1 : if both the logs are letter logs
            if (!isDigit1 && !isDigit2) {
                // compare the content of the logs
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                // contents of the logs are same, compare the identifier
                return split1[0].compareTo(split2[0]);
            }

            // case 2 : one of the log is a digit log
            if (!isDigit1 && isDigit2) {
                return -1;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            }
            // both the logs are digit logs
            else {
                return 0;
            }
        }
    }
}
