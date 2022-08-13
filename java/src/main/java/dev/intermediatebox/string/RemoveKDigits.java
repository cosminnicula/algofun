package dev.intermediatebox.string;
// Tag: String
// Tag: Stack
// Tag: Greedy

import java.util.LinkedList;

// O(n) time complexity (the nested loops will run at most k times globally)
// O(n) space complexity
public class RemoveKDigits {
  public String removeKdigits(String num, int k) {
    LinkedList<Character> stack = new LinkedList<>();

    for (char digit : num.toCharArray()) {
      while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
        stack.removeLast();
        k--;
      }
      stack.addLast(digit);
    }

    // there is no digit left to be removed
    if (k == 0) {
      return getNumberFromDigits(stack);
    }

    // there is at least one digit left to be removed
    for (int i = 0; i < k; ++i) {
      stack.removeLast();
    }

    return getNumberFromDigits(stack);
  }

  private String getNumberFromDigits(LinkedList<Character> stack) {
    String number = "";

    boolean skipLeadingZero = true;
    for (char digit : stack) {
      if (skipLeadingZero && digit == '0') {
        continue;
      }

      skipLeadingZero = false;
      number += digit;
    }

    if (number.length() == 0) {
      return "0";
    }

    return number;
  }
}
