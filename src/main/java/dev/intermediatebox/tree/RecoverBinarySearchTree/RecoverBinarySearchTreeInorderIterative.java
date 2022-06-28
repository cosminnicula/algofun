package dev.intermediatebox.tree.RecoverBinarySearchTree;

import dev.intermediatebox.tree.utils.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBinarySearchTreeInorderIterative {
  public void recoverTree(Node root) {
    recover(root);
  }

  private void recover(Node node) {
    Deque<Node> stack = new ArrayDeque();
    Node pred = null;

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

  private void swap(Node a, Node b) {
    int temp = a.value;
    a.value = b.value;
    b.value = temp;
  }
}
