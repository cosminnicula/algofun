package dev.intermediatebox.tree;
// Tag: LinkedList
// Tag: Stack
// Tag: Tree
// Tag: BinaryTree

import dev.intermediatebox.tree.utils.TreeNode;

// O(n) time complexity
// O(logn) space complexity
public class FlattenBinaryTreeToLinkedList {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    TreeNode leftSubtree = root.left;
    TreeNode rightSubtree = root.right;

    flatten(leftSubtree);
    flatten(rightSubtree);

    root.left = null;
    root.right = leftSubtree;
    TreeNode current = root;
    while (current.right != null) {
      current = current.right;
    }
    current.right = rightSubtree;
  }
}
