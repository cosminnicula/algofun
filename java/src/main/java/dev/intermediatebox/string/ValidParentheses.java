package dev.intermediatebox.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.isValid("()"));
    System.out.println(s.isValid("()[]{}"));
    System.out.println(s.isValid("(]"));
  }

  private static class Solution {
    public boolean isValid(String s) {
      Map<Character, Character> parenthesesMap = Map.of('(', ')', '[', ']', '{', '}');
      Stack<Character> stack = new Stack<>();

      for (Character c: s.toCharArray()) {
        // opening parentheses are pushed to the stack
        if (parenthesesMap.containsKey(c)) {
          stack.push(c);
        } else if (!stack.isEmpty() && parenthesesMap.get(stack.peek()) == c) { // check if current parentheses is a closing one for the last parentheses in the stack
          stack.pop();
        } else {
          return false;
        }
      }

      return stack.isEmpty();
    }
  }
}
