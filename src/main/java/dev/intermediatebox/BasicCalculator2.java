package dev.intermediatebox;

//Given a string s which represents an expression, evaluate this expression and return its value.
//
//The integer division should truncate toward zero.
//
//You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
//
//Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

import java.util.Stack;

// Input: s = "3+1+2*2" -> 8
// Input: s = " 3/2 " -> 1
// Input: s = " 3+5 / 2 " -> 5

// O(n) time complexity
// O(n) space complexity
public class BasicCalculator2 {
  public int run(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    char operation = '+';
    int number = 0;
    Stack<Integer> stack = new Stack<>();
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (isOperation(c) || i == s.length() - 1) {
        if (operation == '+') {
          stack.push(number);
        } else if (operation == '-') {
          stack.push(-number);
        } else if (operation == '*') {
          int previousNumber = stack.pop();
          stack.push(previousNumber * number);
        } else if (operation == '/') {
          int previousNumber = stack.pop();
          stack.push(previousNumber / number);
        }
        operation = c;
        number = 0;
      } else if (isDigit(c)) {
        number = number * 10 + Character.getNumericValue(c);
      }
    }

    for (int item : stack) {
      result += item;
    }

    return result;
  }

  private boolean isDigit(char c) {
    return c - '0' >= 0 && c - '0' <= 9;
  }

  private boolean isOperation(char c) {
    return c == '-' || c == '+' || c == '*' || c == '/';
  }
}
