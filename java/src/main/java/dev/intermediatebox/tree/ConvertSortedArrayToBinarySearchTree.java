package dev.intermediatebox.tree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
  private int[] array;

  public TreeNode sortedArrayToBST(int[] nums) {
    this.array = nums;

    return backtrack(0, nums.length - 1);
  }

  private TreeNode backtrack(int low, int high) {
    if (low > high) {
      return null;
    }

    int mid = low + (high - low) / 2;

    TreeNode head = new TreeNode(array[mid]);

    head.left = backtrack(low, mid - 1);
    head.right = backtrack(mid + 1, high);

    return head;
  }
}
