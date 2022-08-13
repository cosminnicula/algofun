export default class DoublyLinkedListNode {
  public value: number;
  public prev: DoublyLinkedListNode | null;
  public next: DoublyLinkedListNode | null;

  constructor(value: number) {
    this.value = value;
    this.prev = null;
    this.next = null;
  }

  public DoublyLinkedListNode(value: number, prev: DoublyLinkedListNode, next: DoublyLinkedListNode) {
    this.value = value;
    this.prev = prev;
    this.next = next;
  }
}