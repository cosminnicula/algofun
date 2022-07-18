package dev.intermediatebox.tree.utils.TraversalWithLink;

import dev.intermediatebox.tree.utils.TreeNodeWithLink;

import java.util.List;

public class LevelIterative {
  public static void traverse(TreeNodeWithLink root, List<Integer> traversal) {
    TreeNodeWithLink leftNode = root;
    // outer loop: depth traversal
    while (leftNode != null) {
      TreeNodeWithLink current = leftNode;
      // inner loop: width traversal
      while (current != null) {
        traversal.add(current.value);
        current = current.next;
      }
      leftNode = leftNode.left;
    }
  }
}
