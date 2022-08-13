package dev.intermediatebox.tree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Iterative

import dev.intermediatebox.tree.utils.TreeNodeWithLink;

// O(n) time complexity (the two nested while loops traverse the tree only once in total)
// O(1) space complexity (there is no queue involved, like in the breadth-first traversal)
public class PopulateNextRightPointersInEachNode {
  public TreeNodeWithLink connect(TreeNodeWithLink root) {
    if (root == null) {
      return null;
    }

    TreeNodeWithLink leftNode = root;
    // outer loop: depth traversal
    while (leftNode.left != null) {
      // inner loop: width traversal
      TreeNodeWithLink current = leftNode;
      while (current != null) {
        current.left.next = current.right;

        if (current.next != null) {
          current.right.next = current.next.left;
        }
        current = current.next;
      }

      leftNode = leftNode.left;
    }

    return root;
  }
}
