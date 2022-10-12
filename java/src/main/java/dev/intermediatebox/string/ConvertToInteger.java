package dev.intermediatebox.string;

public class ConvertToInteger {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.toInteger("-123"));
    System.out.println(s.toInteger("544"));
    System.out.println(s.toInteger("398732782378782872"));
  }

  private static class Solution {
    public int toInteger(String str) {
      if (str == null || str.length() == 0) {
        throw new IllegalArgumentException("Should not be null or empty");
      }

      long longNumber = 0;
      int i = 0;
      int sign = 1;

      if (str.charAt(i) == '-') {
        sign = -1;
        i++;
      } else if (str.charAt(i) == '+') {
        i++;
      }

      while (i < str.length()) {
        longNumber = longNumber * 10 + (str.charAt(i) - '0');
        if (longNumber > Integer.MAX_VALUE || (sign == -1 && (sign * longNumber) < Integer.MIN_VALUE)) {
          throw new RuntimeException("Overflow");
        }
        i++;
      }

      return (int) (sign * longNumber);
    }
  }
}
