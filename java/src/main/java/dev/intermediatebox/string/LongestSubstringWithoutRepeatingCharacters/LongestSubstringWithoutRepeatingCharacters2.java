package dev.intermediatebox.string.LongestSubstringWithoutRepeatingCharacters;
// Tag: String
// Tag: Set
import java.util.HashSet;
import java.util.Set;

// pwwkew -> longest substring is wke
// abcabcbb -> longest substring is abc

// time complexity O(n^2), space complexity O(1)

// if only ASCII characters, then Set could be replaced with bool[256]
// Unicode supports 1,114,112 characters, while Java int has a maximum value of 2^32-1, so a Set or a Map is more efficient
public class LongestSubstringWithoutRepeatingCharacters2 {
  public int run(String s) {
    int maxLength = 0;
    Set<Integer> visited;

    for (int i = 0; i < s.length(); i++) {
      visited = new HashSet<>();
      for (int j = i; j < s.length(); j++) {
        if (!areUnique(visited, Character.getNumericValue(s.charAt(j)))) {
          break;
        }
        visited.add(Character.getNumericValue(s.charAt(j)));
      }
      maxLength = Math.max(maxLength, visited.size());
    }

    return maxLength;
  }

  private boolean areUnique(Set<Integer> visited, Integer currentChar) {
    return !visited.contains(currentChar);
  }
}
