package dev.intermediatebox.tree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Iterative

// Related:
// BinaryTreeLevelOrderTraversal

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.*;

// O(n) time complexity
// O(n) space complexity
public class BinaryTreeZigZagLevelOrderTraversal {
  List<List<Integer>> traversal = new ArrayList<>();

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return traversal;
    }

    bfsIterative(root);

    return traversal;
  }

  private void bfsIterative(TreeNode node) {
    // can also be achieved with:
    // - two stacks: one stack for current level, and another stack for next level
    // - one queue: isReversed has opposite logic with the stack variant
    Queue<TreeNode> queue = new LinkedList<>();

    int level = 0;
    boolean isReversed = true;

    queue.add(node);
    while (!queue.isEmpty()) {
      traversal.add(new LinkedList<>());

      int length = queue.size();
      for (int i = 0; i < length; i++) {
        TreeNode current = queue.remove();

        traversal.get(level).add(current.value);

        if (isReversed) {
          if (current.left != null) {
            queue.add(current.left);
          }

          if (current.right != null) {
            queue.add(current.right);
          }
        } else {
          if (current.right != null) {
            queue.add(current.right);
          }

          if (current.left != null) {
            queue.add(current.left);
          }
        }
      }

      isReversed = !isReversed;

      level++;
    }
  }
}
