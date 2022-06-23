package dev.intermediatebox.string;
// Tag: String
// Tag: DynamicProgramming
// Tag: Recursion

import java.util.ArrayList;
import java.util.List;

// [recursive]
//Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
//A palindrome string is a string that reads the same backward as forward.

// aab -> [["a","a","b"], ["aa", "b"]]

// O(n*2^n) time complexity (n is the length of the string)
// O(n) space complexity
public class PalindromePartitioning {

  private String s;
  private List<List<String>> solution;

  public List<List<String>> run(String s) {
    this.s = s;
    this.solution = new ArrayList<>();

    backtrack(0, new ArrayList<String>());

    return solution;
  }

  private void backtrack(int index, ArrayList<String> accumulator) {
    if (index >= this.s.length()) {
      solution.add(new ArrayList<>(accumulator));
      return;
    }

    for (int j = index; j < s.length(); j++) {
      if (isPalindrome(s, index, j)) {
        accumulator.add(s.substring(index, j + 1));
        backtrack(j + 1, accumulator);
        accumulator.remove(accumulator.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
