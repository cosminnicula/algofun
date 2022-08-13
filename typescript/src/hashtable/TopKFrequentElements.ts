(() => {  
  function topKFrequent(nums: number[], k: number): number[] {
    const frequency = new Map<number, number>();

    for (let i = 0; i < nums.length; i++) {
      frequency.set(nums[i], frequency.get(nums[i]) !== undefined ? frequency.get(nums[i])! + 1 : 1);
    }

    const sortedFrequencies = [...frequency].sort((a, b) => {
      return b[1] - a[1];
    });

    const result = [];

    for (let i = 0; i < k; i++) {
      result[i] = sortedFrequencies[i][0];
    }

    return result;
  };

  const nums1 = [1, 1, 1, 2, 2, 3];
  const k1 = 2;

  console.log(topKFrequent(nums1, k1));

})();