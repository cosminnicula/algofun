package dev.intermediatebox.math;

public class PalindromeNumber {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.isPalindrome(121));
    System.out.println(s.isPalindrome(-121));
    System.out.println(s.isPalindrome(10));
    System.out.println(s.isPalindrome(1410110141));
  }

  private static class Solution {
    public boolean isPalindrome(int x) {
      int newX = 0;
      int target = x;

      while (x > 0) {
        int lastDigit = x % 10;
        x = x / 10;
        newX = newX * 10 + lastDigit;
      }

      return newX == target;
    }
  }
}
