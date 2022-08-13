package dev.intermediatebox.hashtable;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.longestSubstring("ababbc", 2));
    System.out.println(s.longestSubstring("aaabb", 3));
  }

  // Tag: HashTable

  // O(26 * n^2) time complexity = O(n^2)
  // O(26) = O(1) space complexity
  private static class Solution {
    private int k;

    private String s;

    public int longestSubstring(String s, int k) {
      if (s == null || s.isEmpty() || k > s.length()) {
        return 0;
      }

      this.k = k;
      this.s = s;

      int maxLength = 0;

      for (int i = 0; i < s.length(); i++) {
        int[] frequencies = new int[26];
        Arrays.fill(frequencies, 0);

        for (int j = i; j < s.length(); j++) {
          frequencies[s.charAt(j) - 'a'] += 1;

          // has k repeating chars
          if (hasKRepeatingCharacters(frequencies)) {
            maxLength = Math.max(maxLength, j - i + 1);
          }
        }
      }

      return maxLength;
    }

    private boolean hasKRepeatingCharacters(int[] frequencies) {
      int charactersCount = 0;
      int kRepeatingCharactersCount = 0;

      for (int frequency:  frequencies) {
        if (frequency > 0) {
          charactersCount += 1;
        }

        if (frequency >= k) {
          kRepeatingCharactersCount += 1;
        }
      }

      return charactersCount == kRepeatingCharactersCount;
    }
  }
}
