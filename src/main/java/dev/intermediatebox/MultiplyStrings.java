package dev.intermediatebox;
// Tag: String
// Tag: List

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

//   213*
//   356
//   ---
//  1278
// 10650
// 63900
// -----
// 75828

// O(m*n), where m is the number of digits of the second number, and n is the number of operations
// O(m*(m+n)), where m+n is the maximum length of each multiplication, and m is the number of multiplication results
public class MultiplyStrings {
  public String run(String num1, String num2) {
    List<List<Integer>> multiplicationPartialResults = new ArrayList<>();

    String num1Reversed = new StringBuilder(num1).reverse().toString();
    String num2Reversed = new StringBuilder(num2).reverse().toString();
    // from this point onwards, numbers are reversed

    for (int i = 0; i < num2Reversed.length(); i++) {
      // multiplication between first number and each digit of the second number
      multiplicationPartialResults.add(multiplyNumberWithDigit(num1Reversed, num2Reversed.charAt(i), i));
    }

    // sum all partial multiplication results to get the final result
    List<Integer> result = sumAllNumbers(multiplicationPartialResults);
    Collections.reverse(result);

    return result.toString();
  }

  private List<Integer> multiplyNumberWithDigit(String number, char digit, int numberOfLeadingZeros) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < numberOfLeadingZeros; i++) {
      result.add(0);
    }

    int carry = 0;
    for (char currentDigit : number.toCharArray()) {
      int multiplicationResult = (digit - '0') * (currentDigit - '0') + carry;
      carry = multiplicationResult / 10;

      result.add(multiplicationResult % 10);
    }

    if (carry > 0) {
      result.add(carry);
    }

    return result;
  }

  private List<Integer> sumAllNumbers(List<List<Integer>> numbers) {
    // initialize the result array with the largest number
    List<Integer> result = new ArrayList<>(numbers.get(numbers.size() - 1));

    for (int i = 0; i < numbers.size() - 1; i++) {
      List<Integer> currentNumber = numbers.get(i);
      List<Integer> partialResult = sumTwoNumbers(result, currentNumber);
      result = new ArrayList<>(partialResult);
    }

    return result;
  }

  private List<Integer> sumTwoNumbers(List<Integer> num1, List<Integer> num2) {
    int carry = 0;
    int i = 0;
    List<Integer> result = new ArrayList<>();

    while (i < num1.size() && i < num2.size()) {
      int sum = num1.get(i) + num2.get(i) + carry;
      int partialResult = sum % 10;
      result.add(partialResult);
      carry = sum / 10;
      i++;
    }

    while (i < num1.size()) {
      result.add(num1.get(i) + carry);
      carry = 0;
      i++;
    }

    while (i < num2.size()) {
      result.add(num2.get(i) + carry);
      carry = 0;
      i++;
    }

    return result;
  }
}
