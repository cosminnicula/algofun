package dev.intermediatebox.array;

public class SearchInsertPosition {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
    System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
    System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
  }

  private static class Solution {
    public int searchInsert(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
        int mid = (left + right) / 2;

        if (target == nums[mid]) {
          return mid;
        }

        if (target > nums[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return left;
    }
  }
}
