(() => {
  class RandomizedSet {
    private map: Map<number, number>;
    private list: Array<number>;

    constructor() {
      this.map = new Map();
      this.list = new Array();
    }

    insert(val: number): boolean {
      if (this.map.has(val)) {
        return false;
      }

      this.map.set(val, this.list.length);
      this.list.push(val);

      return true;
    }

    remove(val: number): boolean {
      if (!this.map.has(val)) {
        return false;
      }

      const index = this.map.get(val)!;

      if (index < this.list.length - 1) {
        const lastValue = this.list[this.list.length - 1];
        this.map.set(lastValue, index);
        this.list[index] = lastValue;
      }

      this.map.delete(val);
      this.list.splice(this.list.length - 2, 1);

      return true;
    }

    getRandom(): number {
      return this.list[Math.floor(Math.random() * this.list.length)];
    }
  }

  const r = new RandomizedSet();
  console.log(r.insert(1)); // return true
  console.log(r.remove(2)); // return false
  console.log(r.insert(2)); // return true
  console.log(r.getRandom()); // return random value 1 o
  console.log(r.remove(1)); // return true
  console.log(r.insert(2)); // return false
  console.log(r.getRandom()); // always return 2
})();