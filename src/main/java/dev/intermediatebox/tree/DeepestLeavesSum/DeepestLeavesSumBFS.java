package dev.intermediatebox.tree.DeepestLeavesSum;
// Tag: Tree
// Tag: BinaryTree
// Tag: Iterative

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// Given the root of a binary tree, return the sum of values of its deepest leaves.


public class DeepestLeavesSumBFS {
  public int deepestLeavesSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    int sum = 0;

    queue.add(root);
    while (!queue.isEmpty()) {
      sum = 0;
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        TreeNode node = queue.poll();
        sum += node.value;

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }

    return sum;
  }
}
