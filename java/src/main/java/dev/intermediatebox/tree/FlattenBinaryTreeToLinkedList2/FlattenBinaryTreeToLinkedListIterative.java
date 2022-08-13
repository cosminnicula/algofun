package dev.intermediatebox.tree.FlattenBinaryTreeToLinkedList2;
// Tag: Tree
// Tag: BinaryTree
// Tag: Iterative

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.Stack;

// O(n) time complexity
// O(n) space complexity
public class FlattenBinaryTreeToLinkedListIterative {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    Stack<TreeNode> stack = new Stack<>();

    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();

      if (node.right != null) {
        stack.push(node.right);
      }

      if (node.left != null) {
        stack.push(node.left);
      }

      if (!stack.isEmpty()) {
        node.right = stack.peek();
      }

      node.left = null;
    }
  }
}
