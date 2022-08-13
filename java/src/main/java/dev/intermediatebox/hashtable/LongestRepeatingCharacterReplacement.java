package dev.intermediatebox.hashtable;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.characterReplacement("ABAB", 2));
    System.out.println(s.characterReplacement("AABABBA", 1));
  }

  // O(n) time complexity
  // O(1) space complexity
  private static class Solution {
    public int characterReplacement(String s, int k) {
      int[] frequencies = new int[26];
      int left = 0;

      int maxOccurrences = 0;
      int maxLength = 0;

      for (int right = 0; right < s.length(); right++) {
        // updates the frequencies array for the current character index
        frequencies[s.charAt(right) - 'A'] += 1;

        // keeps track of the maximum occurrence of any letter inside the current substring
        maxOccurrences = Math.max(maxOccurrences, frequencies[s.charAt(right) - 'A']);

        // if length of current substring (right - left + 1) - the maximum occurrence of any letter (maxOccurrences) is greater than k, then move left pointer one position and decrement the frequencies array for that character
        while (right - left + 1 - maxOccurrences > k) {
          frequencies[s.charAt(left) - 'A'] -= 1;
          left += 1;
        }

        maxLength = Math.max(maxLength, right - left + 1);
      }

      return maxLength;
    }
  }
}
