package dev.intermediatebox.array;

import java.util.Arrays;

public class PlusOne {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(Arrays.toString(s.plusOne(new int[]{9, 9, 9})));
  }

  private static class Solution {
    public int[] plusOne(int[] digits) {
      if (digits == null || digits.length == 0) {
        return new int[0];
      }

      int carry = 1;
      for (int i = digits.length - 1; i >= 0; i--) {
        int sum = digits[i] + carry;
        carry = sum >= 10 ? 1 : 0;
        digits[i] = sum % 10;
      }

      if (carry > 0) {
        int[] result = new int[digits.length + 1];
        System.arraycopy(digits, 0 , result, 1, digits.length);
        result[0] = carry;
        return  result;
      }

      return digits;
    }
  }
}
