package dev.intermediatebox.tree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

// Related:
// ConvertSortedArrayToBinarySearchTree

import dev.intermediatebox.string.ListNode;
import dev.intermediatebox.tree.utils.TreeNode;

// O(n) time complexity (the list is traversed only once)
// O(log(n)) space complexity (the height of the tree)
public class ConvertSortedListToBinarySearchTree {
  int listSize;
  ListNode head;

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode current = head;
    int size = 0;
    while (current != null) {
      size++;
      current = current.next;
    }

    this.listSize = size;
    this.head = head;

    return backtrack(0, size - 1);
  }

  private TreeNode backtrack(int low, int high) {
    if (low > high) {
      return null;
    }

    int mid = (low + high) / 2;

    TreeNode left = backtrack(low, mid - 1);

    TreeNode node = new TreeNode(this.head.value);
    node.left = left;
    this.head = this.head.next;

    node.right = backtrack(mid + 1, high);

    return node;
  }
}
