package dev.intermediatebox.list.utils;

public class DoublyLinkedListNode {
  public int value;
  public DoublyLinkedListNode prev;
  public DoublyLinkedListNode next;

  public DoublyLinkedListNode(int value) {
    this.value = value;
  }

  public DoublyLinkedListNode(int value, DoublyLinkedListNode prev, DoublyLinkedListNode next) {
    this.value = value;
    this.prev = prev;
    this.next = next;
  }
}
