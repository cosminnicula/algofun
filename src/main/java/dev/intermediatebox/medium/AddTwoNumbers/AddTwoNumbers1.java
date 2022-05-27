package dev.intermediatebox.medium.AddTwoNumbers;

// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// number1 is 753 -> List.of(3, 5, 7);
// number2 is  78 -> List.of(8, 7);
public class AddTwoNumbers1 {
  public List<Integer> run(List<Integer> number1, List<Integer> number2) {
    int carry = 0;
    int i = 0;
    List<Integer> result = new ArrayList<>();

    // iterate lists
    while (i < number1.size() && i < number2.size()) {
      int sum = (number1.get(i) + number2.get(i)) % 10 + carry;

      result.add(sum);

      carry = (number1.get(i) + number2.get(i)) / 10;
      i++;
    }

    // reached the end of any of the two lists
    while ( i < number1.size()) {
      result.add(number1.get(i) + carry);
      carry = 0;
      i++;
    }

    while ( i < number2.size()) {
      result.add(number2.get(i) + carry);
      carry = 0;
      i++;
    }

    Collections.reverse(result);

    return result;
  }
}
