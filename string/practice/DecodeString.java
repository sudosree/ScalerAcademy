package string.practice;

import java.util.Stack;

public class DecodeString {

  public String decodeString(String s) {
    Stack<Character> stack = new Stack();
    int n = s.length();
    for (int i=0; i<n; i++) {
      char c = s.charAt(i);
      // if the character is a closing bracket then start decoding the encoded string
      if (c == ']') {
        StringBuilder decodedString = new StringBuilder();
        // keep on popping from the stack while the character is not an opening bracket
        while (stack.peek() != '[') {
          decodedString.append(stack.pop());
        }
        // pop the opening bracket
        stack.pop();
        int k = 0;
        int base = 1;
        // if the stack is not empty and the top of the stack is a digit
        while (!stack.empty() && stack.peek() >= '0' && stack.peek() <= '9') {
          k = k + (stack.pop() - '0') * base;
          base *= 10;
        }
        // now we have k and decodedString, decode the pattern k[decodedString] by pushing
        // the decodedString k times
        while (k > 0) {
          for (int j=decodedString.length()-1; j>=0; j--) {
            stack.push(decodedString.charAt(j));
          }
          k--;
        }
      }
      // else for every other character push it to the stack
      else {
        stack.push(c);
      }
    }
    StringBuilder ans = new StringBuilder();
    while (!stack.empty()) {
      ans.append(stack.pop());
    }
    return ans.reverse().toString();
  }

  public String decodeString1(String s) {
    Stack<Integer> countStack = new Stack();
    Stack<StringBuilder> stringStack = new Stack<>();
    StringBuilder currentString = new StringBuilder();
    int k = 0;
    int n = s.length();
    for (int i=0; i<n; i++) {
      char c = s.charAt(i);
      if (c >= '0' && c <= '9') {
        k = k * 10 + c - '0';
      } else if (c == '[') {
        countStack.push(k);
        stringStack.push(currentString);
        k = 0;
        currentString = new StringBuilder();
      } else if (c == ']') {
        StringBuilder decodedString = stringStack.pop();
        int currentK = countStack.pop();
        // decode the pattern currentK[currentString] by appending the currentString k times
        for (int j=currentK; j>0; j--) {
          decodedString.append(currentString);
        }
        currentString = decodedString;
      } else {
        currentString.append(c);
      }
    }
    return currentString.toString();
  }

}
