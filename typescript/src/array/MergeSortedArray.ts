(() => {
  function merge(nums1: number[], m: number, nums2: number[], n: number): void {
    let i = m - 1;
    let j = n - 1;
    let k = m + n - 1;

    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k] = nums1[i];
        i -= 1;
      } else {
        nums1[k] = nums2[j];
        j -= 1;
      }

      k -= 1;
    }

    // if j, which is iterating nums2, reaches the end first, then there's nothing left to do
    // if i, which is iterating nums1, reaches the end first, then all the remaining elements in num2 needs to be iterated
    while (j >= 0) {
      nums1[k] = nums2[j];
      k -= 1;
      j -= 1;
    }
  };


  let nums1: Array<number> = [1, 2, 3, 0, 0, 0];
  let nums2: Array<number> = [2, 5, 6];
  merge(nums1, 3, nums2, 3);
  console.log(nums1);

  nums1 = [2, 2, 3, 0, 0, 0];
  nums2 = [1, 5, 6];
  merge(nums1, 3, nums2, 3);
  console.log(nums1);

  nums1 = [1];
  nums2 = [];
  merge(nums1, 1, nums2, 0);
  console.log(nums1);

  nums1 = [0];
  nums2 = [1];
  merge(nums1, 0, nums2, 1);
  console.log(nums1);
})();