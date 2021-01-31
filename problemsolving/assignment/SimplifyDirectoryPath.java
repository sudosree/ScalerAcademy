package problemsolving.assignment;

import java.util.*;

/**
 * Given a string A representing an absolute path for a file (Unix-style).
 *
 * Return the string A after simplifying the absolute path.
 *
 * Note:
 *
 *     Absolute path always begin with '/' ( root directory ).
 *
 *     Path will not have whitespace characters.
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 *
 * Output Format
 *
 * Return a string denoting the simplified absolue path for a file (Unix-style).
 *
 * For Example
 *
 * Input 1:
 *     A = "/home/"
 * Output 1:
 *     "/home"
 *
 * Input 2:
 *     A = "/a/./b/../../c/"
 * Output 2:
 *     "/c"
 */
public class SimplifyDirectoryPath
{
    public static String simplifyPath(String A) {
        String[] str = A.split("/");
        Stack<String> stack = new Stack<>();
        for (int i=1;i<str.length;i++) {
            if (!str[i].equals(".") && !str[i].equals("..") && !str[i].isEmpty()) {
                stack.push(str[i]);
            } else if (str[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String name : stack) {
            sb.append("/");
            sb.append(name);
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        String A = "/home//foo/";
        System.out.println(simplifyPath(A));
    }
}
