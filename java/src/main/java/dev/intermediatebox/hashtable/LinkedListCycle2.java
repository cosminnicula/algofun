package dev.intermediatebox.hashtable;

import dev.intermediatebox.list.utils.ListNode;

public class LinkedListCycle2 {
  public static void main(String[] args) {
    Solution s = new Solution();

    ListNode head = new ListNode(3);
    ListNode cycleNode = new ListNode(2);
    head.next = cycleNode;
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(-4);
    head.next.next.next.next = cycleNode;

    ListNode node = s.detectCycle(head);
    System.out.println(node != null ? node.value : "no cycle");
  }

  // Tag: HashTable
  // Tag: LinkedList

  // O(n) time complexity
  // O(1) space complexity
  private static class Solution {
    public ListNode detectCycle(ListNode head) {
      if (head == null) {
        return null;
      }

      ListNode slow = head;
      ListNode fast = head;

      // move slow with one position and fast with 2 positions. if they meet, the list has a cycle
      while (slow != null && fast != null) {
        slow = slow.next;
        fast = fast.next;
        if (fast != null) {
          fast = fast.next;
        }

        if (slow == fast) {
          break;
        }
      }

      if (fast == null) {
        return null;
      }

      // at this point the list is guaranteed to have a cycle, so iterate it again, by moving slow and fast with one position until they meet
      // the meeting point is where the cycle begins
      slow = head;
      while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
      }

      return slow;
    }
  }
}
