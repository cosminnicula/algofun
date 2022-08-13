package dev.intermediatebox.array;
// Tag: Array

// O(n) time complexity
// O(n) space complexity
public class SumOfEvenNumbersAfterQueries {
  public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

    int[] sums = new int[nums.length];
    int sumEven = 0;

    for (int num : nums) {
      if (num % 2 == 0) {
        sumEven += num;
      }
    }

    for (int i = 0; i < queries.length; i++) {
      int value = queries[i][0];
      int index = queries[i][1];

      if (nums[index] % 2 == 0) {
        sumEven -= nums[index];
      }

      nums[index] += value;

      if (nums[index] % 2 == 0) {
        sumEven += nums[index];
      }

      sums[i] = sumEven;
    }

    return sums;
  }
}
