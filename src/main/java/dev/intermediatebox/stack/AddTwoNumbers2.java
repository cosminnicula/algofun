package dev.intermediatebox.stack;

import dev.intermediatebox.string.ListNode;

import java.util.Stack;

public class AddTwoNumbers2 {
  public static void main(String[] args) {
    // solution1: reverse the lists
    ListNode l1 = new ListNode(7);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    l1.next.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    Solution1 s1 = new Solution1();

    ListNode result1 = s1.addTwoNumbers(l1, l2);

    while (result1 != null) {
      System.out.println(result1.value);
      result1 = result1.next;
    }

    // solution2: use two stacks (don't reverse the list)
    l1 = new ListNode(7);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    l1.next.next.next = new ListNode(3);

    l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    Solution2 s2 = new Solution2();

    ListNode result2 = s2.addTwoNumbers(l1, l2);

    while (result2 != null) {
      System.out.println(result2.value);
      result2 = result2.next;
    }
  }

  // Tag: LinkedList

  // O(n) time complexity (reverse and sumLists have linear time complexity)
  // O(n) space complexity (the length of the result list)
  private static class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if (l1 == null && l2 == null) {
        return new ListNode(0);
      }

      ListNode l1Reversed = reverse(l1);
      ListNode l2Reversed = reverse(l2);

      ListNode reversedResult = sumLists(l1Reversed, l2Reversed);

      return reverse(reversedResult);
    }

    private ListNode reverse(ListNode node) {
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

    private ListNode sumLists(ListNode l1, ListNode l2) {
      Integer carry = 0;
      ListNode current = null;
      ListNode result = null;

      while (l1 != null || l2 != null) {
        Integer val1 = l1 != null ? l1.value : 0;
        Integer val2 = l2 != null ? l2.value : 0;

        Integer sum = val1 + val2 + carry;

        carry = sum / 10;

        if (current == null) {
          current = new ListNode(sum %10);
          result = current;
        } else {
          current.next = new ListNode(sum %10);
          current = current.next;
        }

        if (l1 != null) {
          l1 = l1.next;
        }

        if (l2 != null) {
          l2 = l2.next;
        }
      }

      if (carry > 0) {
        current.next = new ListNode(carry);
      }

     return result;
    }
  }

  // Tag: LinkedList
  // Tag: Stack

  // O(n) time complexity (reverse and sumStacks have linear time complexity)
  // O(n) space complexity (the length of the result list + length of the two stacks)
  private static class Solution2 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

      while (l1 != null) {
        stack1.push(l1.value);
        l1 = l1.next;
      }

      while (l2 != null) {
        stack2.push(l2.value);
        l2 = l2.next;
      }

      return reverse(sumStacks());
    }

    private ListNode reverse(ListNode node) {
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

    private ListNode sumStacks() {
      int carry = 0;
      ListNode current = null;
      ListNode head = null;

      while (!stack1.isEmpty() || !stack2.isEmpty()) {
        int val1 = !stack1.isEmpty() ? stack1.pop(): 0;
        int val2 = !stack2.isEmpty() ? stack2.pop(): 0;

        int sum = val1 + val2 + carry;

        if (current == null) {
          current = new ListNode(sum %10);
          head = current;
        } else {
          current.next = new ListNode(sum %10);
          current = current.next;
        }

        carry = sum / 10;
      }

      if (carry > 0) {
        current.next = new ListNode(carry);
      }

      return head;
    }
  }
}
