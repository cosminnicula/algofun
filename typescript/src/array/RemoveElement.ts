(() => {
  function removeElement(nums: number[], val: number): number {
    if (nums.length === 0) {
      return 0;
    }
    
    let i = 0;

    for (let j = 0; j < nums.length; j++) {
        if (nums[j] !== val) {
          nums[i] = nums[j];
          i++;
        }
    }

    return i;
  };

  console.log(removeElement([3,2,2,3], 3));  
})();