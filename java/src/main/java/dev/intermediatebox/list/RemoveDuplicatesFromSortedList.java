package dev.intermediatebox.list;

import dev.intermediatebox.list.utils.ListNode;

public class RemoveDuplicatesFromSortedList {
  public static void main(String[] args) {
    Solution s = new Solution();

    ListNode list = new ListNode(1);
    list.next = new ListNode(1);
    list.next.next = new ListNode(2);
    list.next.next.next = new ListNode(2);
    list.next.next.next.next = new ListNode(3);
    list.next.next.next.next.next = new ListNode(3);

    ListNode head = s.deleteDuplicates(list);;
    while (head != null) {
      System.out.println(head.value );
      head = head.next;
    }
  }

  private static class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode current = head;

      while (current != null) {
        while (current.next != null && current.value == current.next.value) {
          ListNode oldNext = current.next;

          current.next = current.next.next;

          oldNext.next = null;
        }
        current = current.next;
      }

      return head;
    }
  }
}
