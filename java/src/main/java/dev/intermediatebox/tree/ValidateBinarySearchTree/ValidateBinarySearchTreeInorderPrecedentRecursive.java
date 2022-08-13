package dev.intermediatebox.tree.ValidateBinarySearchTree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.TreeNode;

// O(n) time complexity
// O(n) space complexity
public class ValidateBinarySearchTreeInorderPrecedentRecursive {
  TreeNode precedent = null;

  public boolean isValidBST(TreeNode root) {
    return isValid(root);
  }

  private boolean isValid(TreeNode node) {
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
