package dev.intermediatebox.dynamicprogramming;

import java.util.Arrays;

public class ClimbingStairs {
  public static void main(String[] args) {
    Solution1 s1 = new Solution1();
    System.out.println(s1.climbStairs(3));
    System.out.println(s1.climbStairs(5));

    Solution2 s2 = new Solution2();
    System.out.println(s2.climbStairs(3));
    System.out.println(s2.climbStairs(5));

    Solution3 s3 = new Solution3();
    System.out.println(s3.climbStairs(3));
    System.out.println(s3.climbStairs(5));

    Solution4 s4 = new Solution4();
    System.out.println(s4.climbStairs(3));
    System.out.println(s4.climbStairs(5));
  }

  // O(2^n) time complexity
  // O(n) space complexity
  private static class Solution1 {
    public int climbStairs(int n) {
      if (n < 2) {
        return 1;
      }

      return climbStairs(n - 1) + climbStairs(n - 2);
    }
  }

  // O(n) time complexity due to Memoization
  // O(n) space complexity
  private static class Solution2 {
    private int climbStairsHelper(int n, int[] dp) {
      if (n < 2) {
        return 1;
      }

      if (dp[n] != -1) {
        return dp[n];
      }

      dp[n] = climbStairsHelper(n - 1, dp) + climbStairsHelper(n - 2, dp);

      return dp[n];
    }

    public int climbStairs(int n) {
      int[] dp = new int[n + 1];
      Arrays.fill(dp, -1);

      return climbStairsHelper(n, dp);
    }
  }

  // O(n) time complexity (Dynamic Programming / Fibonacci sequence)
  // O(n) space complexity
  private static class Solution3 {
    public int climbStairs(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;

      for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
      }

      return dp[n];
    }
  }

  // O(n) time complexity (Dynamic Programming / Fibonacci sequence)
  // O(1) space complexity
  private static class Solution4 {
    public int climbStairs(int n) {
      int one = 1;
      int two = 1;

      for (int i = 0; i < n - 1; i++) {
        int temp = one;
        one = one + two;
        two = temp;
      }

      return one;
    }
  }
}
