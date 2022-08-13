
import DoublyLinkedListNode from '../list/util/DoublyLinkedListNode';

(() => {  
  class CircularQueue {
    private size: number;
    private left: DoublyLinkedListNode;
    private right: DoublyLinkedListNode;
   
    constructor(k: number) {
      this.size = k;
      this.left = new DoublyLinkedListNode(-1);
      this.right = new DoublyLinkedListNode(-1);
      this.left.next = this.right;
      this.right.prev = this.left;
    }

    public enQueue(value: number): boolean {
      if (this.isFull()) {
        return false;
      }

      const node: DoublyLinkedListNode = new DoublyLinkedListNode(value);
      node.prev = this.right.prev;
      node.next = this.right;
      this.right.prev!.next = node;
      this.right.prev! = node;
      this.size -= 1;

      return true;
    }

    public deQueue(): boolean {
      if (this.isEmpty()) {
        return false;
      }

      this.left.next = this.left.next!.next;
      this.left.next!.prev = this.left;
      this.size += 1;

      return true;
    }

    public Front(): number {
      if (this.isEmpty()) {
        return -1;
      }

      return this.left.next!.value;
    }

    public Rear(): number {
      if (this.isEmpty()) {
        return -1;
      }

      return this.right.prev!.value;
    }

    public isEmpty(): boolean {
      return this.left.next == this.right;
    }

    public isFull(): boolean {
      return this.size === 0;
    }
  }
  

  const c: CircularQueue = new CircularQueue(3);

  console.log(c.enQueue(1)); // return True
  console.log(c.enQueue(2)); // return True;
  console.log(c.enQueue(3)); // return True;
  console.log(c.enQueue(4)); // return False
  console.log(c.Rear()); // return 3
  console.log(c.isFull()); // return True
  console.log(c.deQueue()); // return True
  console.log(c.enQueue(4)); // return True
  console.log(c.Rear()); // return 4
})();