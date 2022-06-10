package dev.intermediatebox;
// Tag: String
// Tag: HashTable

import java.util.*;

// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// ["eat","tea","tan","ate","nat","bat"] -> [["bat"],["nat","tan"],["ate","eat","tea"]]

// solution 2: encode strings (assuming only 26 lower-case letters)

// O(n*k) time complexity, where k is the maximum length of a string
// O(n*k) space complexity
public class GroupAnagrams2 {
  public List<List<String>> groupAnagrams(String[] strings) {
    Map<String, List<String>> anagrams = new HashMap<>();

    for (String string : strings) {
      String encodedString = encode(string);
      if (anagrams.get(encodedString) == null) {
        anagrams.put(encodedString, new ArrayList<>());
      }
      anagrams.get(encodedString).add(string);
    }

    return new ArrayList<>(anagrams.values());
  }

  private String encode(String string) {
    int[] characterCounter = new int[26];
    Arrays.fill(characterCounter, 0);

    // count each character occurrence
    for (char c : string.toCharArray()) {
      characterCounter[c - 'a']++;
    }

    String encodedString = "";
    for (int i = 0; i < characterCounter.length; i++) {
      encodedString += "#" + characterCounter[i];
    }

    return encodedString;
  }
}
