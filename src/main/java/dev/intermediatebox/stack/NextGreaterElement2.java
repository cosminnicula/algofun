package dev.intermediatebox.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(Arrays.toString(s.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    System.out.println(Arrays.toString(s.nextGreaterElements(new int[]{10, 6, 5, 8, 9})));
  }

  // Tag: Stack
  // Tag: Monotonic Stack
  // Tag: Array

  // O(n) time complexity (the two traversals)
  // O(n) space complexity (the size of the stack and the size of the resolution array)
  private static class Solution {
    public int[] nextGreaterElements(int[] nums) {
      Stack<Integer> stack = new Stack<>();
      int[] solution = new int[nums.length];
      Arrays.fill(solution, -1);

      for (int i = 0; i < nums.length; i++) {
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
          // given that the stack is constructed in decreasing order, all the elements to the left which are smaller than nums[i], have num[i] as their next greater element
          solution[stack.pop()] = nums[i];
        }

        stack.push(i);
      }

      // at this point, the stack is in descending order; iterating the nums array one more time will fill the remaining elements in the solution array
      for (int i = 0; i < nums.length; i++) {
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
          solution[stack.pop()] = nums[i];
        }
      }

      return solution;
    }
  }
}
