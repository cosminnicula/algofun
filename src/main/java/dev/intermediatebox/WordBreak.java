package dev.intermediatebox;
// Tag: String
// Tag: HashTable
// Tag: DynamicProgramming
// Tag: Memoization


import java.util.HashSet;
import java.util.List;
import java.util.Set;

// [dynamic programming]

//Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//Note that the same word in the dictionary may be reused multiple times in the segmentation.

// "applepenapple", wordDict = ["apple","pen"] -> true
// "catsandog", wordDict = ["cats","dog","sand","and","cat"] -> false
// "catsanddog", wordDict = ["cats","dog","sand","and","cat"] -> true

// O(n^3) time complexity (two nested loops, and one substring)
// O(n) space complexity
public class WordBreak {

  public boolean run(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    Set<String> words = new HashSet<>(wordDict);

    dp[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        String word = s.substring(j, i);

        if (dp[j] && words.contains(word)) {
          dp[i] = true;
          break;
        }
      }
    }

    return dp[s.length()];
  }
}
