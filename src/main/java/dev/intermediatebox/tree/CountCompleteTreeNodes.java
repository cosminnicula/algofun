package dev.intermediatebox.tree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.TreeNode;

// n represents leafs
// in a complete binary tree:
// - total number of nodes = 2n + 1
// - total number of leaf nodes = n + 1
// - total number of internal nodes = n
// - total number of levels = log2(2n + 1)
// - binary search on leafs = log2(n + 1)
// O(log(2n + 1) * log(n+1)) = O(log(n) * log(n)) time complexity
//
public class CountCompleteTreeNodes {
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return backtrack(root);
  }

  private int backtrack(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftDepth = 1;
    TreeNode leftNode = node.left;
    while (leftNode != null) {
      leftDepth += 1;
      leftNode = leftNode.left;
    }

    int rightDepth = 1;
    TreeNode rightNode = node.right;
    while (rightNode != null) {
      rightDepth += 1;
      rightNode = rightNode.right;
    }

    if (leftDepth == rightDepth) {
      return (int) Math.pow(2, leftDepth) - 1;
    }

    return 1 + backtrack(node.left) + backtrack(node.right);
  }
}
