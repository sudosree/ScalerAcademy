package stack.practice;

import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int n = s.length(), m = t.length();
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c != '#') {
                s1.push(c);
            } else {
                if (s1.empty()) {
                    continue;
                }
                s1.pop();
            }
        }
        for (int i=0; i<m; i++) {
            char c = t.charAt(i);
            if (c != '#') {
                s2.push(c);
            } else {
                if (s2.empty()) {
                    continue;
                }
                s2.pop();
            }
        }
        while (!s1.empty() && !s2.empty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }
        return s1.empty() && s2.empty();
    }

    public boolean backspaceCompare1(String s, String t) {
        int n = s.length(), m = t.length();
        int i = n-1, j = m-1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0)  {
                char c = s.charAt(i);
                if (c == '#') {
                    skipS++;
                    i--;
                }
                // skip the current character
                else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                char c = t.charAt(j);
                if (c == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            if (i >= 0 != j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
