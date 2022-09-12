package dev.intermediatebox.string;

public class LengthOfLastWord {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.lengthOfLastWord("Hello World"));
    System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
  }

  private static class Solution {
    public int lengthOfLastWord(String s) {
      int i = s.length() - 1;
      while (i >= 0 && s.charAt(i) == ' ') {
        i -= 1;
      }

      int length = 0;

      while (i >= 0 && s.charAt(i) != ' ') {
        i -= 1;
        length += 1;
      }

      return length;
    }
  }
}
