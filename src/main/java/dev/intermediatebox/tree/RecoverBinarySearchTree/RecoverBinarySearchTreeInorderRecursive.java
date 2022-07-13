package dev.intermediatebox.tree.RecoverBinarySearchTree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursion

import dev.intermediatebox.tree.utils.TreeNode;

public class RecoverBinarySearchTreeInorderRecursive {
  TreeNode swapped1, swapped2, pred;

  public void recoverTree(TreeNode root) {
    findSwapped(root);
    swap(swapped1, swapped2);
  }

  private void findSwapped(TreeNode node) {
    if (node == null) {
      return;
    }
    findSwapped(node.left);

    if (pred != null && node.value < pred.value) {
      swapped2 = node;
      swapped1 = pred;
      return;
    }
    pred = node;

    findSwapped(node.right);
  }

  private void swap(TreeNode node1, TreeNode node2) {
    int temp = node1.value;
    node1.value = node2.value;
    node2.value = temp;
  }
}
