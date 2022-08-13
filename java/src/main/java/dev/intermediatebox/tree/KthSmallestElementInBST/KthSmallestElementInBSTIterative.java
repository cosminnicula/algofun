package dev.intermediatebox.tree.KthSmallestElementInBST;
// Tag: Tree
// Tag: BinaryTree
// Tag: Iterative

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

// O(n) time complexity
// O(n) space complexity
public class KthSmallestElementInBSTIterative {

  public int kthSmallest(TreeNode root, int k) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int kthSmallest = 0;
    Deque<TreeNode> stack = new LinkedList<>();

    // iterative inorder traversal
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      node = stack.pop();
      kthSmallest += 1;

      if (kthSmallest == k) {
        return node.value;
      }

      node = node.right;
    }

    return Integer.MIN_VALUE;
  }
}
