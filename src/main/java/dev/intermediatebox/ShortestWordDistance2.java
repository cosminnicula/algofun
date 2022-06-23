package dev.intermediatebox;
// Tag: String
// Tag: TwoPointers
// Tag: HashTable
// Tag: Array

//Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.
//
//Implement the WordDistance class:
//
//WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
//int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.

//WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
//wordDistance.shortest("coding", "practice"); // return 3
//wordDistance.shortest("makes", "coding");    // return 1 (makes -> 1, 4; coding -> 3)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// O(max(n,m)) time complexity, where n and m are number of occurrences of the two words
// O(n) space complexity (the map)
public class ShortestWordDistance2 {
  Map<String, List<Integer>> map;

  public ShortestWordDistance2(String[] wordsDict) {
    if (wordsDict == null || wordsDict.length == 0) {
      return;
    }

    map = new HashMap<>();

    for (int i = 0; i < wordsDict.length; i++) {
      String word = wordsDict[i];
      if (!map.containsKey(word)) {
        map.put(word, new ArrayList<>());
      }

      map.get(word).add(i); // indexes for each word are sorted in ascending order
    }

  }

  public int shortest(String word1, String word2) {
    if (!map.containsKey(word1) || !map.containsKey(word2)) {
      return -1;
    }

    List<Integer> indexes1 = map.get(word1);
    List<Integer> indexes2 = map.get(word2);
    int minDistance = Integer.MAX_VALUE;


    int i = 0, j = 0;
    while (i < indexes1.size() && j < indexes2.size()) {
      int index1 = indexes1.get(i);
      int index2 = indexes2.get(j);
      int distance = Math.abs(index1 - index2);

      minDistance = Math.min(distance, minDistance);

      if (index1 < index2) {
        i++;
      } else {
        j++;
      }
    }

    return minDistance;
  }
}
