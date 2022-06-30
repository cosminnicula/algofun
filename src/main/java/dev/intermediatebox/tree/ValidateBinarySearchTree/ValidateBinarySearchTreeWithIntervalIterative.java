package dev.intermediatebox.tree.ValidateBinarySearchTree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Iterative

import dev.intermediatebox.tree.utils.Node;

import java.util.Deque;
import java.util.LinkedList;

// O(n) time complexity
// O(n) space complexity
public class ValidateBinarySearchTreeWithIntervalIterative {
  private Deque<Node> stack = new LinkedList();
  private Deque<Integer> upperBounds = new LinkedList();
  private Deque<Integer> lowerBounds = new LinkedList();

  public boolean isValidBST(Node node) {
    Integer lowerBound = null, upperBound = null, val;

    pushToStacks(node, lowerBound, upperBound);

    while (!stack.isEmpty()) {
      node = stack.poll();
      lowerBound = lowerBounds.poll();
      upperBound = upperBounds.poll();

      val = node.value;

      if (lowerBound != null && val <= lowerBound) {
        return false;
      }

      if (upperBound != null && val >= upperBound) {
        return false;
      }

      if (node.right != null) {
        pushToStacks(node.right, val, upperBound);
      }

      if (node.left != null) {
        pushToStacks(node.left, lowerBound, val);
      }
    }

    return true;
  }

  public void pushToStacks(Node root, Integer low, Integer high) {
    stack.add(root);
    lowerBounds.add(low);
    upperBounds.add(high);
  }
}