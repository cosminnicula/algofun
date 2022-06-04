package dev.intermediatebox;

//A message containing letters from A-Z can be encoded into numbers using the following mapping:
//
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
//
//To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways).
//
// For example, "11106" can be mapped into:
//"AAJF" with the grouping (1 1 10 6)
//"KJF" with the grouping (11 10 6)
//
//Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
//
//Given a string s containing only digits, return the number of ways to decode it.
//
//The test cases are generated so that the answer fits in a 32-bit integer.

import java.util.HashMap;
import java.util.Map;

// O(n) time complexity, thanks to memoization technique
// O(n) space complexity (O(n) size of the map + O(n) size of the recursion stack)
public class WaysToDecode {
  Map<Integer, Integer> memo = new HashMap<>();

  public int run(String s) {
    return backtrack(s, 0);
  }

  private int backtrack(String s, int i) {
    // check if substring was seen before
    if (memo.containsKey(i)) {
      return memo.get(i);
    }

    if (i == s.length()) {
      return 1;
    }

    if (s.charAt(i) == '0') {
      return 0;
    }

    if (i == s.length() - 1) {
      return 1;
    }

    int result = backtrack(s, i + 1);

    int twoDigitNumber = Integer.parseInt(s.substring(i, i + 2));
    if (twoDigitNumber <= 26) {
      result += backtrack(s, i + 2);
    }

    // cache result
    memo.put(i, result);

    return result;
  }
}
