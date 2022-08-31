package dev.intermediatebox.string;

public class LongestCommonPrefix {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    System.out.println(s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
  }

  private static class Solution {
    public String longestCommonPrefix(String[] strs) {
      String prefix = "";

      // iterate all characters in the first string
      for (int i = 0; i < strs[0].length(); i++) {
        // iterate all strings in the array
        for (String s: strs) {
          if (i == s.length() || s.charAt(i) != strs[0].charAt(i)) {
            return prefix;
          }
        }

        prefix = prefix + strs[0].charAt(i);
      }

      return prefix;
    }
  }
}
