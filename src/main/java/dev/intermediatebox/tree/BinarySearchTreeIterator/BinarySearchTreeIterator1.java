package dev.intermediatebox.tree.BinarySearchTreeIterator;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.Traversal.DFSRecursive;
import dev.intermediatebox.tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

// O(1) time complexity
// O(n) space complexity (the traversal array)
public class BinarySearchTreeIterator1 {
  List<Integer> traversal = new LinkedList<>();
  int iteratorPosition = 0;

  public BinarySearchTreeIterator1(TreeNode root) {
    DFSRecursive.inorder(root, traversal);
  }

  public int next() {
    // throws IndexOutOfBoundsException if next is called without calling hasNext first
    int value = traversal.get(iteratorPosition);
    iteratorPosition += 1;
    return value;
  }

  public boolean hasNext() {
    return iteratorPosition < traversal.size();
  }
}
