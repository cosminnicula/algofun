package dev.intermediatebox.hashtable;

import java.util.*;

public class RandomPickIndex {
  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 3, 3};

    Solution1 s1 = new Solution1(nums);
    System.out.println(s1.pick(3));
    System.out.println(s1.pick(1));
    System.out.println(s1.pick(3));

    Solution2 s2 = new Solution2(nums);
    System.out.println(s2.pick(3));
    System.out.println(s2.pick(1));
    System.out.println(s2.pick(3));
  }

  // Tag: HashTable
  // Tag: List

  // O(n) time complexity, because of the list creation
  // O(n) space complexity for the list
  private static class Solution1 {
    private int[] nums;

    public Solution1(int[] nums) {
      this.nums = nums;
    }

    public int pick(int target) {
      List<Integer> list = new ArrayList<>();

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
          list.add(i);
        }
      }

      return list.get(new Random().nextInt(list.size()));
    }
  }

  // O(n) time complexity, because of the map creation; O(1) time complexity for pick operation
  // O(n) space complexity for the map
  private static class Solution2 {
    private int[] nums;

    private Map<Integer, ArrayList<Integer>> map;

    public Solution2(int[] nums) {
      this.nums = nums;

      this.map = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
        if (!map.containsKey(nums[i])) {
          map.put(nums[i], new ArrayList<>());
        }

        map.get(nums[i]).add(i);
      }
    }

    public int pick(int target) {
      List<Integer> indexes = map.get(target);
      return map.get(target).get(new Random().nextInt(indexes.size()));
    }
  }
}
