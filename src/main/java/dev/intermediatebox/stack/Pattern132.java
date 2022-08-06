package dev.intermediatebox.stack;

import java.util.Stack;

public class Pattern132 {
  public static void main(String[] args) {
    Solution s = new Solution();

    int[] nums = new int[]{3, 1, 4, 2};
    System.out.println(s.find132pattern(nums));
  }

  // Tag: Array
  // Tag: Stack
  // Tag: Monotonic Stack

  // O(2n)=O(n) time complexity
  // O(2n)=O(n) space complexity
  private static class Solution {
    public boolean find132pattern(int[] nums) {
      if (nums.length <= 2) {
        return false;
      }

      // conditions that need to be satisfied: i < j < k AND nums[i] < nums[k] < nums[j]

      // the min array holds at each index i, the minimum of the "left" side
      int[] min = new int[nums.length];
      min[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        min[i] = Math.min(nums[i], min[i - 1]);
      }

      // e.g. [-1, 3, 2, 0]
      Stack<Integer> stack = new Stack<>();
      for (int j = nums.length - 1; j >= 0; j--) {
        // given i, j, k indexes (or j-1, j, j+1), going from right to left, if nums[j] > min[j], then first part of the condition "nums[i] < nums[k]" is satisfied
        if (nums[j] > min[j]) {
          // while current element on the stack is less than the minimum, then pop it, because it can't possibly satisfy the second part of the condition "nums[k] < nums[j]"
          while (!stack.isEmpty() && stack.peek() <= min[j]) {
            stack.pop();
          }

          // check if the current element in the stack (nums[j+1]) is less than current num (nums[j]), which is the second part of the condition "nums[k] < nums[j]"
          if (!stack.isEmpty() && stack.peek() < nums[j]) {
            return true;
          }

          // the stack retains all the numbers in descending order which are > min[j]
          stack.push(nums[j]);
        }
      }

      return false;
    }
  }
}
