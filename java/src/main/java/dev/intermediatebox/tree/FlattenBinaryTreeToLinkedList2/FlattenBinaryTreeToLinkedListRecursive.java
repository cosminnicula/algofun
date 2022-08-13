package dev.intermediatebox.tree.FlattenBinaryTreeToLinkedList2;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.TreeNode;

// O(n) time complexity
// O(n) space complexity
public class FlattenBinaryTreeToLinkedListRecursive {
  TreeNode previous = null;

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    flattenTree(root);
  }

  // reversed postorder traversal
  private void flattenTree(TreeNode node) {
    if (node == null) {
      return;
    }

    flattenTree(node.right);

    flattenTree(node.left);

    node.right = previous;
    node.left = null;
    previous = node;
  }
}
