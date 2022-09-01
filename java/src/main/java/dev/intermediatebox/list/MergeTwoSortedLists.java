package dev.intermediatebox.list;

import dev.intermediatebox.list.utils.ListNode;

public class MergeTwoSortedLists {
  public static void main(String[] args) {
    Solution s = new Solution();

    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(2);
    list1.next.next = new ListNode(4);

    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(3);
    list2.next.next = new ListNode(4);

    ListNode merged = s.mergeTwoLists(list1, list2);
    while (merged != null) {
      System.out.println(merged.value);
      merged = merged.next;
    }
  }

  private static class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      // list3 is a dummy node to allow easier logic for an empty list
      ListNode list3 = new ListNode();
      ListNode current3 = list3;

      while (list1 != null && list2 != null) {
        if (list1.value > list2.value) {
          current3.next = list2;
          list2 = list2.next;
        } else {
          current3.next = list1;
          list1 = list1.next;
        }

        current3 = current3.next;
      }

      if (list1 != null) {
        current3.next = list1;
      } else if (list2 != null) {
        current3.next = list2;
      }

      return list3.next;
    }
  }
}
