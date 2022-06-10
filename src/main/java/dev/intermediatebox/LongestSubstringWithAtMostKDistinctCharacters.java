package dev.intermediatebox;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
// Input: s = "eceba", k = 2 -> output 3 ("ece")
public class LongestSubstringWithAtMostKDistinctCharacters {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s.length() * k == 0) {
      return 0;
    }

    Map<Character, Integer> lastIndex = new HashMap<>();
    int left = 0;
    int right = 0;
    int maxLength = 1;

    while (right < s.length()) {
      Character c = s.charAt(right);

      lastIndex.put(c, right);

      right++;

      if (lastIndex.size() > k) {
        int minIndex = Collections.min(lastIndex.values());

        left = minIndex + 1;

        lastIndex.remove(s.charAt(minIndex));
      }

      maxLength = Math.max(maxLength, right - left);
    }

    return maxLength;
  }
}
