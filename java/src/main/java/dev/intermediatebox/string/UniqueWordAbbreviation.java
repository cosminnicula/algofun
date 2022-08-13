package dev.intermediatebox.string;
// Tag: String
// Tag: HashTable
// Tag: Array

//The abbreviation of a word is a concatenation of its first letter, the number of characters between the first and last letter, and its last letter. If a word has only two characters, then it is an abbreviation of itself.
//
//For example:
//
//dog --> d1g because there is one letter between the first letter 'd' and the last letter 'g'.
//internationalization --> i18n because there are 18 letters between the first letter 'i' and the last letter 'n'.
//it --> it because any word with only two characters is an abbreviation of itself.
//
//Implement the ValidWordAbbr class:
//
//ValidWordAbbr(String[] dictionary) Initializes the object with a dictionary of words.
//boolean isUnique(string word) Returns true if either of the following conditions are met (otherwise returns false):
//There is no word in dictionary whose abbreviation is equal to word's abbreviation.
//For any word in dictionary whose abbreviation is equal to word's abbreviation, that word and word are the same.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation {
  Map<String, Set<String>> map = new HashMap<>();

  public UniqueWordAbbreviation(String[] dictionary) {
    for (int i = 0; i < dictionary.length; i++) {
      String abbreviation = getAbbreviation(dictionary[i]);
      Set<String> set = map.containsKey(abbreviation) ? map.get(abbreviation) : new HashSet<>();
      set.add(dictionary[i]);
      map.put(abbreviation, set);
    }
  }

  public boolean isUnique(String word) {
    String abbreviation = getAbbreviation(word);
    return !map.containsKey(abbreviation) ||
        (map.get(abbreviation).contains(word) && map.get(abbreviation).size() == 1);
  }

  private String getAbbreviation(String s) {
    if (s.length() < 3) {
      return s;
    }

    return s.substring(0, 1) + String.valueOf(s.length() - 2) + s.substring(s.length() - 1);
  }
}
