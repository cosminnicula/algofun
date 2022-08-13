package dev.intermediatebox.hashtable;

import java.util.*;

public class InsertDeleteGetRandomO1 {
  public static void main(String[] args) {
    RandomizedSet r = new RandomizedSet();

    System.out.println(r.insert(1)); // return true
    System.out.println(r.remove(2)); // return false
    System.out.println(r.insert(2)); // return true
    System.out.println(r.getRandom());  // return random value 1 or 2
    System.out.println(r.remove(1)); // return true
    System.out.println(r.insert(2)); // return false
    System.out.println(r.getRandom()); // always return 2
  }

  // Tag: HashTable

  // O(1) time complexity for all operations
  // O(n) space complexity for hash and map
  private static class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
      map = new HashMap<>();
      list = new ArrayList<>();
    }

    public boolean insert(int val) {
      if (map.containsKey(val)) {
        return false;
      }

      map.put(val, list.size());
      list.add(val);

      return true;
    }

    public boolean remove(int val) {
      if (!map.containsKey(val)) {
        return false;
      }

      int index = map.get(val);

      if (index < list.size() - 1) {
        // switch last value with value at current index
        int lastValue = list.get(list.size() - 1);
        map.put(lastValue, index);
        list.set(index, lastValue);
      }

      // removes value from the map
      map.remove(val);
      // removes value from the list
      list.remove(list.size() - 1);

      return true;
    }

    public int getRandom() {
      return list.get(new Random().nextInt(list.size()));
    }
  }
}
