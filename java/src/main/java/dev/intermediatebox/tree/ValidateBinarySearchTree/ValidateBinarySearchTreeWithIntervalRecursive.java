package dev.intermediatebox.tree.ValidateBinarySearchTree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.TreeNode;

// O(n) time complexity
// O(n) space complexity
public class ValidateBinarySearchTreeWithIntervalRecursive {
  public boolean isValidBST(TreeNode root) {
    return isValid(root, null, null);
  }

  private boolean isValid(TreeNode node, Integer lowerBound, Integer upperBound) {
    if (node == null) {
      return true;
    }

    if ((lowerBound != null && node.value < lowerBound) || (
        upperBound != null && node.value > upperBound
        )) {
      return false;
    }

    return isValid(node.left, lowerBound, node.value) && isValid(node.right, node.value, upperBound);
  }
}
