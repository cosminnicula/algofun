package dev.intermediatebox.string;
// Tag: String
// Tag: Recursion

//An additive number is a string whose digits can form an additive sequence.
//
//A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
//
//Given a string containing only digits, return true if it is an additive number or false otherwise.
//
//Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

import java.util.ArrayList;
import java.util.List;

// Input: "112358" -> Output: true (1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8)
// Input: "199100199" -> Output true (1 + 99 = 100, 99 + 100 = 199)
public class AdditiveNumber {
  public boolean isAdditiveNumber(String num) {
    return backtrack(num, 0, new ArrayList<>());
  }

  private boolean backtrack(String num, int index, List<Integer> accumulator) {
    if (index == num.length() && accumulator.size() >= 3) {
      return true;
    }

    for (int i = index; i < num.length(); i++) {
      Integer currentNumber = Integer.valueOf(num.substring(index, i + 1));

      if (accumulator.size() <= 1 || (currentNumber == accumulator.get(accumulator.size() - 2) + accumulator.get(accumulator.size() - 1))) {
        accumulator.add(currentNumber);
        if (backtrack(num, i + 1, accumulator)) {
          return true;
        }
        accumulator.remove(accumulator.size() - 1);
      }
    }

    return false;
  }
}
