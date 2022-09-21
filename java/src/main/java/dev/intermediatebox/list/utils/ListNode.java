package dev.intermediatebox.list.utils;

public class ListNode {
  public int value;
  public ListNode next;

  public ListNode() { }

  public ListNode(int value) {
    this.value = value;
  }

  public ListNode(int value, ListNode next) {
    this.value = value;
    this.next = next;
  }
}
