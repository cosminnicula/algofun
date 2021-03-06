package dev.intermediatebox.tree.RecoverBinarySearchTree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Iterative

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBinarySearchTreeInorderIterative {
  public void recoverTree(TreeNode root) {
    recover(root);
  }

  private void recover(TreeNode node) {
    Deque<TreeNode> stack = new ArrayDeque();
    TreeNode pred = null;

    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.add(node);
        node = node.left;
      }
      node = stack.removeLast();
      if (pred != null && node.value < pred.value) {
        swap(pred, node);
        break;
      }
      pred = node;
      node = node.right;
    }
  }

  private void swap(TreeNode node1, TreeNode node2) {
    int temp = node1.value;
    node1.value = node2.value;
    node2.value = temp;
  }
}
