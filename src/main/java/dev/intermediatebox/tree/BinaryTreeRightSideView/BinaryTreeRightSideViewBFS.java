package dev.intermediatebox.tree.BinaryTreeRightSideView;
// Tag: Tree
// Tag: BinaryTree
// Tag: Iterative

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.*;

// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
// O(n) time complexity (the nodes are visited only once)
// O(n) space complexity (for complete binary tree, where the number of leaves is n/2)
public class BinaryTreeRightSideViewBFS {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Queue<TreeNode> currentLevel = new LinkedList<>();
    Queue<TreeNode> nextLevel = new LinkedList<>();
    List<Integer> rightSide = new ArrayList();

    nextLevel.add(root);
    while (!nextLevel.isEmpty()) {
      currentLevel = cloneQueue(nextLevel);
      nextLevel.clear();

      TreeNode node = null;

      // BFS backbone
      while (!currentLevel.isEmpty()) {
        node = currentLevel.poll();

        if (node.left != null) {
          nextLevel.add(node.left);
        }

        if (node.right != null) {
          nextLevel.add(node.right);
        }
      }

      // node is here the rightmost value, so add it to the rightSide array
      rightSide.add(node.value);
    }

    return rightSide;
  }

  private Queue<TreeNode> cloneQueue(Queue<TreeNode> source) {
    Queue<TreeNode> destination = new LinkedList<>();
    for (TreeNode node : source) {
      destination.add(node);
    }
    return destination;
  }
}
