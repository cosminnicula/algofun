package dev.intermediatebox.tree.KthSmallestElementInBST;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.TreeNode;

// O(n) time complexity
// O(n) space complexity
public class KthSmallestElementInBSTRecursive {
  private int kthSmallest;

  public int kthSmallest(TreeNode root, int k) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    kthSmallest = k;
    return backtrack(root);
  }

  // recursive inorder traversal
  private int backtrack(TreeNode node) {
    if (node == null) {
      return Integer.MIN_VALUE;
    }

    int left = backtrack(node.left);
    if (left != Integer.MIN_VALUE) {
      return left;
    }

    kthSmallest -= 1;
    if (kthSmallest == 0) {
      return node.value;
    }

    int right = backtrack(node.right);
    return right;
  }
}
