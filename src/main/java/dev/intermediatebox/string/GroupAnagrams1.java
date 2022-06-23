package dev.intermediatebox.string;
// Tag: String
// Tag: Sort

import java.util.*;

// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// ["eat","tea","tan","ate","nat","bat"] -> [["bat"],["nat","tan"],["ate","eat","tea"]]

// solution 1: sort strings
// O(n*klog(k)) time complexity, where n is the length of strings array, and k is the maximum length of a string within the array
// O(n*k) space complexity (the map)
public class GroupAnagrams1 {
  public List<List<String>> groupAnagrams(String[] strings) {
    Map<String, List<String>> anagrams = new HashMap<>();

    for (String string : strings) {
      char[] chars = string.toCharArray();
      // strings that have identical sorted representation are anagrams
      Arrays.sort(chars);
      String key = String.valueOf(chars);

      if (anagrams.get(key) == null) {
        anagrams.put(key, new ArrayList<>());
      }
      anagrams.get(key).add(string);
    }

    return new ArrayList(anagrams.values());
  }
}
