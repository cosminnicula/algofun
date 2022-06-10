package dev.intermediatebox;

import java.util.*;

//We can shift a string by shifting each of its letters to its successive letter.
//
//For example, "abc" can be shifted to be "bcd".
//
//We can keep shifting the string to form a sequence.
//
//For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
//
//Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any order.

// O(n*k) time complexity, where n is number of strings and k is maximum length of a string
// O(n*k) space complexity
public class GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s: strings) {
      String shifted = getShiftedString(s);

      if (!map.containsKey(shifted)) {
        map.put(shifted, new ArrayList<>());
      }

      map.get(shifted).add(s);

    }

    List<List<String>> groups = new ArrayList<>();
    for (List<String> group : map.values()) {
      groups.add(group);
    }

    return groups;
  }

  private String getShiftedString(String s) {
    int shift = s.charAt(0);
    char[] chars = s.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      chars[i] = shiftChar(chars[i], shift);
    }

    return String.valueOf(chars);
  }

  private char shiftChar(char c, int shift) {
    // in Java, expression like (a - b) % c can be negative if a < b hence we need to manually add c to make it non-negative (a - b + c) % c
    return (char)((c - shift + 26) % 26 + 'a');
  }
}
