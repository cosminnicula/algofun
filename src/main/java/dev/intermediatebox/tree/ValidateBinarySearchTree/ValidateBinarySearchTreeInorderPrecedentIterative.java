package dev.intermediatebox.tree.ValidateBinarySearchTree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Iterative

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

// O(n) time complexity
// O(n) space complexity
public class ValidateBinarySearchTreeInorderPrecedentIterative {
  private Deque<TreeNode> stack = new LinkedList();
  Integer precedent = null;

  public boolean isValidBST(TreeNode root) {
    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();

      if (precedent != null && root.value <= precedent) {
        return false;
      }

      precedent = root.value;

      root = root.right;
    }

    return true;
  }
}
