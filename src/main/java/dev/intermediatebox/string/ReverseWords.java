package dev.intermediatebox.string;
// Tag: String
// Tag: TwoPointers

import java.util.ArrayList;
import java.util.List;

//Given an input string s, reverse the order of the words.
//
//A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
//
//Return a string of the words in reverse order concatenated by a single space.
//
//Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

// "  a good   example  " -> "example good a"

// O(n) time complexity
// O(n) space complexity
public class ReverseWords {
  public String run(String s) {
    // remove leading and trailing spaces from the entire string
    String trimmed = trim(s);

    // split words
    List<String> words = split(trimmed);

    // reverse words
    String reversed = "";
    for (int i = words.size() - 1; i >= 0; i--) {
      reversed += words.get(i);
      if (i > 0) {
        reversed += " ";
      }
    }

    return reversed;
  }

  private String trim(String s) {
    String trimmed = s;
    int left = 0, right = s.length() - 1;

    while (left < right && s.charAt(left) == ' ') {
      left++;
    }

    while (left < right && s.charAt(right) == ' ') {
      right--;
    }

    return s.substring(left, right + 1);
  }

  private List<String> split(String s) {
    List<String> words = new ArrayList<>();
    String word = "";

    for (char c : s.toCharArray()) {
      if (c != ' ') {
        word += String.valueOf(c);
      } else if (word.length() > 0) {
        words.add(word);
        word = "";
      }
    }

    if (word.length() > 0) {
      words.add(word);
    }

    return words;
  }
}
