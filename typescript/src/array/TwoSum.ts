(() => {
  function twoSum(nums: number[], target: number): number[] {
    const seen = new Map<number, number>();

    for (let i = 0; i < nums.length; i++) {
      const complement = target - nums[i];

      if (seen.has(complement)) {
        return [i, seen.get(complement)!];
      }

      seen.set(nums[i], i);
    }

    throw new Error('no solution found');
  };

  console.log(twoSum([2, 7, 11, 15], 9));
  console.log(twoSum([3, 2, 4], 6));
  console.log(twoSum([3, 3], 6));
})();