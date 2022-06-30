package dev.intermediatebox.tree.ValidateBinarySearchTree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.Node;

// O(n) time complexity
// O(n) space complexity
public class ValidateBinarySearchTreeInorderPrecedentRecursive {
  Node precedent = null;

  public boolean isValidBST(Node root) {
    return isValid(root);
  }

  private boolean isValid(Node node) {
    if (node == null) {
      return true;
    }

    if (!isValid(node.left)) {
      return false;
    }

    if (precedent != null && node.value <= precedent.value) {
      return false;
    }

    precedent = node;

    return isValid(node.right);
  }
}
