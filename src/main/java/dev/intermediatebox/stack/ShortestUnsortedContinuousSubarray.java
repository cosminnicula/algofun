package dev.intermediatebox.stack;

import java.util.Arrays;
import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
  public static void main(String[] args) {
    int[] nums1 = new int[]{2, 6, 4, 8, 10, 9, 15};
    int[] nums2 = new int[]{1, 2, 3, 4};

    // 2, 6, 4, 8, 10, 9, 15
    // 2, 4, 6, 8, 9, 10, 15
    Solution1 s1 = new Solution1();

    System.out.println(s1.findUnsortedSubarray(nums1));
    System.out.println(s1.findUnsortedSubarray(nums2));

    Solution2 s2 = new Solution2();

    System.out.println(s2.findUnsortedSubarray(nums1));
    System.out.println(s2.findUnsortedSubarray(nums2));

    Solution3 s3 = new Solution3();

    System.out.println(s3.findUnsortedSubarray(nums1));
    System.out.println(s3.findUnsortedSubarray(nums2));
  }

  // Tag: Stack
  // Tag: MonotonicStack
  // Tag: Array

  // O(nlog(n)) time complexity (sort)
  // O(n) space complexity (the clone of the original array)
  private static class Solution1 {
    public int findUnsortedSubarray(int[] nums) {
      if (nums.length < 2) {
        return 0;
      }

      int[] sortedNums = nums.clone();
      Arrays.sort(sortedNums);

      int start = sortedNums.length - 1;
      int end = 0;

      for (int i = 0; i < sortedNums.length; i++) {
        if (nums[i] != sortedNums[i]) {
          // when start is initialized the first time with i, it will remain that way, because subsequent i's will be greater than the first i
          start = Math.min(start, i);
          end = Math.max(end, i);
        }
      }

      return end - start >= 0 ? end - start + 1 : 0;
    }
  }

  // O(n) time complexity (the two for loops)
  // O(n) space complexity (size of the stack)
  private static class Solution2 {
    public int findUnsortedSubarray(int[] nums) {
      if (nums.length < 2) {
        return 0;
      }

      Stack<Integer> stack = new Stack<>();
      int start = nums.length - 1;
      int end = 0;

      for (int i = 0; i < nums.length; i++) {
        // keep stack in ascending order
        while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
          // when start is initialized the first time with i, it will remain that way, so we could break the loops after first initialization
          start = Math.min(start, stack.pop());
        }

        stack.push(i);
      }

      stack.clear();

      for (int i = nums.length - 1; i >= 0; i--) {
        // keep stack in descending order
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
          // when end is initialized the first time with i, it will remain that way, so we could break the loops after first initialization
          end = Math.max(end, stack.pop());
        }

        stack.push(i);
      }

      return end - start >= 0 ? end - start + 1 : 0;
    }
  }

  // O(n) time complexity
  // O(1) space complexity
  private static class Solution3 {
    public int findUnsortedSubarray(int[] nums) {
      if (nums.length < 2) {
        return 0;
      }

      int start = nums.length - 1;
      int end = 0;

      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;

      for (int i = 0; i < nums.length; i++) {
        max = Math.max(max, nums[i]);
        if (nums[i] < max) {
          end = i;
        }
      }

      for (int i = nums.length - 1; i >= 0; i--) {
        min = Math.min(min, nums[i]);
        if (nums[i] > min) {
          start = i;
        }
      }

      return end - start >= 0 ? end - start + 1 : 0;
    }
  }
}
