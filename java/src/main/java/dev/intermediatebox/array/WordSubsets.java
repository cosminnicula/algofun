package dev.intermediatebox.array;

import java.util.LinkedList;
import java.util.List;

public class WordSubsets {
  public List<String> wordSubsets(String[] words1, String[] words2) {
    List<String> solution = new LinkedList<>();

    int[] words2CharFrequency = new int[26];
    for (String word2 : words2) {
      int[] word2CharFrequency = new int[26];

      // O(1) time complexity, because 1 <= words2[i].length <= 10
      for (char ch : word2.toCharArray()) {
        word2CharFrequency[ch - 'a'] += 1;
        words2CharFrequency[ch - 'a'] = Math.max(words2CharFrequency[ch - 'a'], word2CharFrequency[ch - 'a']);
      }
    }

    for (String word1 : words1) {
      int[] word1CharFrequency = new int[26];

      // O(1) time complexity, because 1 <= words1[i].length <= 10
      for (char ch: word1.toCharArray()) {
        word1CharFrequency[ch - 'a'] += 1;
      }

      if (isSubset(words2CharFrequency, word1CharFrequency)) {
        solution.add(word1);
      }
    }

    return solution;
  }

  private boolean isSubset(int[] source, int[] target) {
    // O(1) time complexity, because of fixed size loop
    for (int i = 0; i < 26; i++) {
      if (source[i] > target[i]) {
        return false;
      }
    }

    return true;
  }
}
