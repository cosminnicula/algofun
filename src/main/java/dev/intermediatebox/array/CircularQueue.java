package dev.intermediatebox.array;
// Tag: Array
// Tag: LinkedList
// Tag: Queue

import dev.intermediatebox.list.utils.DoublyLinkedListNode;

// O(1) time complexity for all operations
// O(n) space complexity for the queue
public class CircularQueue {
  int size;

  // dummy nodes that allow inserting in between
  DoublyLinkedListNode left;
  DoublyLinkedListNode right;

  public CircularQueue(int k) {
    this.size = k;
    left = new DoublyLinkedListNode(-1);
    right = new DoublyLinkedListNode(-1);
    left.next = right;
    right.prev = left;
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }

    DoublyLinkedListNode node = new DoublyLinkedListNode(value);
    node.prev = this.right.prev;
    node.next = this.right;
    this.right.prev.next = node;
    this.right.prev = node;
    this.size -= 1;

    return true;
  }

  public boolean deQueue() {
    if(isEmpty()) {
      return false;
    }

    this.left.next = this.left.next.next;
    this.left.next.prev = this.left;
    this.size += 1;

    return true;
  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    }

    return this.left.next.value;
  }

  public int Rear() {
    if (isEmpty()) {
      return -1;
    }

    return this.right.prev.value;
  }

  public boolean isEmpty() {
    return this.left.next == this.right;
  }

  public boolean isFull() {
    return this.size == 0;
  }
}
