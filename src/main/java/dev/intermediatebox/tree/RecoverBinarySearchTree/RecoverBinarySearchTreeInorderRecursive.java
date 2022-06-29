package dev.intermediatebox.tree.RecoverBinarySearchTree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursion

import dev.intermediatebox.tree.utils.Node;

public class RecoverBinarySearchTreeInorderRecursive {
  Node swapped1, swapped2, pred;

  public void recoverTree(Node root) {
    findSwapped(root);
    swap(swapped1, swapped2);
  }

  private void findSwapped(Node node) {
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

  private void swap(Node node1, Node node2) {
    int temp = node1.value;
    node1.value = node2.value;
    node2.value = temp;
  }
}
