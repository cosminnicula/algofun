package dev.intermediatebox.string;
// Tag: String
// Tag: Recursion
// Tag: Stack

// Given an encoded string, return its decoded string.
//
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
//
//The test cases are generated so that the length of the output will never exceed 10^5.


// Input: s = "3[a2[c]]" -> Output: "accaccacc"

public class DecodeString {
  private int index;

  public String decodeString(String s) {

    index = 0;
    return backtrack(s);
  }

  private String backtrack(String s) {
    String str = "";

    while (index < s.length() && s.charAt(index) != ']') {
      if (!isDigit(s.charAt(index))) {
        str += s.charAt(index);
        index++;
      } else {
        int number = 0;
        while (index < s.length() && isDigit(s.charAt(index))) {
          number = number * 10 + s.charAt(index) - '0';
          index++;
        }

        // skip '['
        index++;

        String inner = backtrack(s);

        // skip ']'
        index++;

        while (number > 0) {
          str += inner;
          number--;
        }
      }
    }

    return str;
  }

  private boolean isDigit(Character c) {
    return c >= '0' && c <= '9';
  }
}
