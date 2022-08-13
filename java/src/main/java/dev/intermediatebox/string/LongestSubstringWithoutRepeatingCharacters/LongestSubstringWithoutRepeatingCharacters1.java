package dev.intermediatebox.string.LongestSubstringWithoutRepeatingCharacters;
// Tag: String
// Tag: Set

import java.util.HashSet;
import java.util.Set;

// pwwkew -> longest substring is wke
// abcabcbb -> longest substring is abc
// https://www.enjoyalgorithms.com/blog/longest-substring-without-repeating-characters

// brute force O(n^3) time complexity, and O(1) space complexity
public class LongestSubstringWithoutRepeatingCharacters1 {
  public int run(String s) {
    int maxLenght = 0;

    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        // check if new max length > max length
        if (areUnique(s, i, j)) {
          maxLenght = Math.max(maxLenght, j - i + 1);
        }
      }
    }

    return maxLenght;
  }

  private boolean areUnique(String s, int i, int j) {
    Set<Integer> visited = new HashSet<>();

    for (int k = i; k < j + 1; k++ ) {
      char currentChar = s.charAt(k);
      if (visited.contains(Character.getNumericValue(currentChar))) {
        return false;
      }
      visited.add(Character.getNumericValue(currentChar));
    }

    return true;
  }

}
