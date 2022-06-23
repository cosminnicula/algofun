package dev.intermediatebox;
// Tag: String
// Tag: DynamicProgramming

// Given a string s, return the longest palindromic substring in s.

// "abcbd" -> "bcb"
// "abbc" -> "bb"

// expand around center
// O(n^2) time complexity (outer loop * expand around the corner loop); O(1) space complexity
public class LongestPalindromicSubstring {
  public String run(String s) {
    int low = 0, high = 0;

    for (int i = 0; i < s.length(); i++) {
      int boundedPalindromeLength = 0;
      if (s.length() % 2 == 0) {
        boundedPalindromeLength = getBoundedPalindromeLength(s, i, i + 1); // even length strings should expand around two centers
      } else {
        boundedPalindromeLength = getBoundedPalindromeLength(s, i, i); // odd length strings should expand around a single center
      }

      if (boundedPalindromeLength > high - low) {
        low = i - (boundedPalindromeLength - 1) / 2; // inclusive low
        high = i + boundedPalindromeLength / 2; // inclusive high
      }
    }

    return s.substring(low, high + 1); // substring() method needs inclusive low and exclusive high
  }

  private int getBoundedPalindromeLength(String s, int low, int high) {
    int newLow = low, newHigh = high;
    while (newLow >= 0 && newHigh < s.length() && s.charAt(newLow) == s.charAt(newHigh)) {
      newLow -= 1;
      newHigh += 1;
    }

    return newHigh - newLow - 1;
  }
}
