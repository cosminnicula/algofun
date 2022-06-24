package dev.intermediatebox.tree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursion

import dev.intermediatebox.string.utils.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
  List<List<Integer>> levels = new ArrayList<List<Integer>>();

  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return levels;
    }

    backtrack(root, 0);

    return levels;
  }

  private void backtrack(Node node, int level) {
    if (levels.size() == level) {
      levels.add(new ArrayList<>());
    }

    levels.get(level).add(node.value);

    if (node.left != null) {
      backtrack(node.left, level + 1);
    }

    if (node.right != null) {
      backtrack(node.right, level + 1);
    }
  }
}
