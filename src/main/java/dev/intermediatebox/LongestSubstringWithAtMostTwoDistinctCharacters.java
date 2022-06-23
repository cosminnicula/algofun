package dev.intermediatebox;
// Tag: String
// Tag: SlidingWindow
// Tag: HashTable

// Given a string s, return the length of the longest substring that contains at most two distinct characters.

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


// "caaaaaaaabdeeeeeeeeefa" -> 10

// O(n) time complexity
// O(1) space complexity (hashmap with at most 3 elements)
public class LongestSubstringWithAtMostTwoDistinctCharacters {
  public int run(String s) {
    if (s.length() <= 2) {
      return s.length();
    }

    int left = 0, right = 0;
    int max = 2;

    HashMap<Character, Integer> lastIndex = new HashMap<>();

    while (right < s.length()) {
      Character c = s.charAt(right);

      lastIndex.put(c, right);

      right++;

      if (lastIndex.size() > 2) {
        // identify the lowest index
        int minIndex = Collections.min(lastIndex.values());

        // move left
        left = minIndex + 1;

        // remove the character associated with the lowest index
        lastIndex.remove(s.charAt(minIndex));
      }

      max = Math.max(max, right - left);
    }

    return max;
  }
}
