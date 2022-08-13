(() => {
  class Solution1 {
    private nums: number[];

    constructor(nums: number[]) {
      this.nums = nums;
    }

    pick(target: number): number {
      const indexes: number[] = [];

      for (let i = 0; i < this.nums.length; i++) {
        if (nums[i] === target) {
          indexes.push(nums[i]);
        }
      }

      return indexes[Math.floor(Math.random() * indexes.length)];
    }
  }

  class Solution2 {
    private map: Map<number, Array<number>>;
    private nums: number[];

    constructor(nums: number[]) {
      this.nums = nums;
      this.map = new Map();

      for (let i = 0; i < nums.length; i++) {
        if (!this.map.has(nums[i])) {
          this.map.set(nums[i], new Array());
        }

        this.map.get(nums[i])!.push(i);
      }
    }

    pick(target: number): number {
      return this.map.get(target)![Math.floor(Math.random() * this.map.get(target)!.length)];
    }
  }

  const nums = [1, 2, 3, 3, 3];


  const s1 = new Solution1(nums);
  console.log(s1.pick(3));
  console.log(s1.pick(1));
  console.log(s1.pick(3));

  const s2 = new Solution2(nums);
  console.log(s2.pick(3));
  console.log(s2.pick(1));
  console.log(s2.pick(3));
})();