package dev.intermediatebox.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15},9)));
    System.out.println(Arrays.toString(s.twoSum(new int[]{3, 2, 4}, 6)));
    System.out.println(Arrays.toString(s.twoSum(new int[]{3, 3}, 6)));
  }

  private static class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> seen = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];

        if (seen.containsKey(complement)) {
          return new int[] { i, seen.get(complement)};
        }

        seen.put(nums[i], i);
      }

      throw new IllegalArgumentException("no solution found.");
    }
  }
}
