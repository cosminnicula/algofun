package dev.intermediatebox.tree.BinarySearchTreeIterator;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// O(1) time complexity
// O(h) space complexity (h is the height of the tree)
public class BinarySearchTreeIterator2 {
  Deque<TreeNode> stack = new ArrayDeque();

  public BinarySearchTreeIterator2(TreeNode root) {
    traverseLeft(root);
  }

  // this is the "left" part of the inorder traversal
  private  void traverseLeft(TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }

  // this is the "right" part of the inorder traversal
  public int next() {
    TreeNode node = stack.pop();
    traverseLeft(node.right);
    return node.value;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }
}
