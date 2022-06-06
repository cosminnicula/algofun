package dev.intermediatebox;

//Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.
//
//A string s is said to be one distance apart from a string t if you can:
//
//Insert exactly one character into s to get t.
//Delete exactly one character from s to get t.
//Replace exactly one character of s with a different character to get t.

// s = "ab", t = "acb" -> true
// s = "abb", t = "acb" -> true
// s = "ab", t = "abc" -> true
// s = "ab", t = "ab" -> false
// s = "", t = "" -> false

// O(n) time complexity
// O(n) space complexity (strings are immutable => substring creates a new string)
public class OneEditDistance {
  public boolean run(String s, String t) {
    // switch the two strings, so to always have the first string < second string
    if (s.length() > t.length()) {
      run(t, s);
    }

    // more than one edit distance apart
    if (t.length() - s.length() >= 2) {
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        if (s.length() < t.length()) { // first string is smaller than second string
          return s.substring(i).equals(t.substring(i + 1));
        } else { // the two strings have the same length
          return s.substring(i + 1).equals(t.substring(i + 1));
        }
      }
    }

    // the two strings are exactly one edit distance apart
    // returns false if the two strings are identical
    return s.length() == t.length() - 1;
  }
}
