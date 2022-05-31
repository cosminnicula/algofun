package dev.intermediatebox;

// 1. Read in and ignore any leading whitespace.
// 2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
// 3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
// 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
// 5. If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -2^31 should be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.
// 6. Return the integer as the final result.
// "  -125 something" -> -125
// "+123" -> 123
// "   " -> 0
// " 123" -> 123
// " -" -> 0
// " 0012" -> 12
// "0999999999999" -> 2147483647
// "-0999999999999 99" -> -2147483648

// O(n) time complexity; O(1) space complexity
public class Atoi {
  public int run(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int i = 0;
    int sign = 1;
    int number;
    int length = s.length();

    i = skipLeadingWhitespaces(s, i);

    // reached end of the string
    if (i >= length) {
      return 0;
    }

    // after reading all whitespaces, next character should be a sign or a digit
    if (s.charAt(i) == '-') {
      sign = -1;
      i++;
    } else if (s.charAt(i) == '+') {
      i++;
    }

    // reached end of the string
    if (i >= length) {
      return 0;
    }

    // remove all leading 0's
    i = skipAllLeadingZeros(s, i);

    // reached end of the string
    if (i >= length) {
      return 0;
    }

    number = getNumberFromDigits(s, i, sign);

    return sign * number;
  }

  private int skipLeadingWhitespaces(String s, int i) {
    while (i < s.length()) {
      if (s.charAt(i) != ' ') {
        break;
      }
      i++;
    }
    return i;
  }

  private int skipAllLeadingZeros(String s, int i) {
    while (s.charAt(i) == '0') {
      i++;
    }
    return i;
  }

  private int getNumberFromDigits(String s, int i, int sign) {
    int number = 0;
    while (i < s.length() && Character.isDigit(s.charAt(i))) {
      int currentDigit = Character.getNumericValue(s.charAt(i));
      // overflow
      if (number > Integer.MAX_VALUE / 10 || number == Integer.MAX_VALUE / 10 && currentDigit > Integer.MAX_VALUE % 10) {
        if (sign == 1) {
          return Integer.MAX_VALUE;
        }

        return  Integer.MIN_VALUE;
      }
      number = number * 10 + currentDigit;
      i++;
    }
    return number;
  }
}
