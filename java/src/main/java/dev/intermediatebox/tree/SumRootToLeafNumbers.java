package dev.intermediatebox.tree;

import dev.intermediatebox.tree.utils.TreeNode;

// O(n) time complexity
// O(1) space complexity
public class SumRootToLeafNumbers {
  int sum = 0;

  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }

    sum(root, 0);

    return sum;
  }

  private void sum(TreeNode node, int accumulator) {
    accumulator = accumulator * 10 + node.value;

    // check if current node is leaf
    if (node.left == null && node.right == null) {
      sum = sum + accumulator;
    }

    if (node.left != null) {
      sum(node.left, accumulator);
    }

    if (node.right != null) {
      sum(node.right, accumulator);
    }

  }
}
