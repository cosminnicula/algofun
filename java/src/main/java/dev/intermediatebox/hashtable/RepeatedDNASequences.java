package dev.intermediatebox.hashtable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
  public static void main(String[] args) {
    Solution s = new Solution();

    String string = "AAAAAAAAAAA";

    System.out.println(s.findRepeatedDnaSequences(string));
  }

  // Tag: Set
  // Tag: List

  // O(n) time complexity (substring is constant in time)
  // O(n) space complexity
  private static class Solution {

    Set<String> seen;
    public List<String> findRepeatedDnaSequences(String s) {
      if (s == null || s.length() <= 10) {
        return new LinkedList<>();
      }

      this.seen = new HashSet<>();
      Set<String> result = new HashSet<>();

      for (int i = 0; i <= s.length() - 10; i++) {
        String sequence = s.substring(i, i + 10);

        if (seen.contains(sequence)) {
          result.add(sequence);
        }

        seen.add(sequence);
      }

      return result.stream().toList();
    }
  }
}
