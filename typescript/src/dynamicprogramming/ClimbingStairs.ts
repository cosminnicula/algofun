(() => {
  // O(2^n) time complexity
  // O(n) space complexity
  function climbStairs1(n: number): number {
    if (n < 2) {
      return 1;
    }

    return climbStairs1(n - 1) + climbStairs1(n - 2);
  };

  // O(n) time complexity due to Memoization
  // O(n) space complexity
  function climbStairs2(n: number): number {
    function climbStairsHelper(n: number, dp: Array<number>): number {
      if (n < 2) {
        return 1;
      }

      if (dp[n] !== -1) {
        return dp[n];
      }

      dp[n] = climbStairsHelper(n - 1, dp) + climbStairsHelper(n - 2, dp);

      return dp[n];
    }

    let dp: Array<number> = new Array(n + 1);
    dp = dp.fill(-1, 0, n + 1);

    return climbStairsHelper(n, dp);
  };

  // O(n) time complexity (Dynamic Programming / Fibonacci sequence)
  // O(n) space complexity
  function climbStairs3(n: number): number {
    let dp: Array<number> = new Array(n + 1);
    dp[0] = 1;
    dp[1] = 1;

    for (let i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  // O(n) time complexity (Dynamic Programming / Fibonacci sequence)
  // O(1) space complexity
  function climbStairs4(n: number): number {
    let one = 1;
    let two = 1;

    for (let i = 0; i < n -1; i ++) {
      const temp = one;
      one = one + two;
      two = temp;
    }

    return one;
  }

  console.log(climbStairs1(3));
  console.log(climbStairs1(5));

  console.log(climbStairs2(3));
  console.log(climbStairs2(5));

  console.log(climbStairs3(3));
  console.log(climbStairs3(5));

  console.log(climbStairs4(3));
  console.log(climbStairs4(5));
})();