package dev.intermediatebox.list;
// Tag: LinkedList
// Tag: TwoPointers

import dev.intermediatebox.string.ListNode;

// O(n) time complexity
// O(1) space complexity
public class ReorderList {
  // head of first half
  ListNode l1Head;
  // tail of first half
  ListNode l1Tail;
  // head of second half (slow moving pointer)
  ListNode l2Head;
  // tail of second half (fast moving pointer)
  ListNode l2Tail;

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    l1Head = head;
    l1Tail = head;
    l2Head = head;
    l2Tail = head;

    splitList();

    l2Head = reverseList(l2Head);

    mergeLists(l1Head, l2Head);
  }

  private void splitList() {
    // 1->2->3->4->5->6->7->8
    // l1H     l1T
    //            l2H
    //                        l2T
    while (l2Tail != null && l2Tail.next != null) {
      l1Tail = l2Head;
      l2Head = l2Head.next;
      l2Tail = l2Tail.next.next;
    }

    l1Tail.next = null;
  }

  private ListNode reverseList(ListNode node) {
    //    5->6->7->8
    // nH c  n
    ListNode newHead = null;
    ListNode current = node;

    while (current != null) {
      ListNode next = current.next;
      current.next = newHead;
      newHead = current;
      current = next;
    }

    return newHead;
  }

  private void mergeLists(ListNode l1Head, ListNode l2Head) {
    // 1->2->3->4->5->6->7->8
    // l1H        l2H
    //  l1Tmp       l2Tmp
    while(l2Head != null) {
      ListNode l1Temp = l1Head.next;
      ListNode l2Temp = l2Head.next;

      l1Head.next = l2Head;
      l2Head.next = l1Temp;

      l1Head = l1Temp;
      l2Head = l2Temp;
    }
  }
}
