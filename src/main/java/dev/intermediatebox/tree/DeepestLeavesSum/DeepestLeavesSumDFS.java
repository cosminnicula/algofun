package dev.intermediatebox.tree.DeepestLeavesSum;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.Node;

import java.util.ArrayList;
import java.util.List;

public class DeepestLeavesSumDFS {
  List<Integer> levelSums = new ArrayList<>();

  public int deepestLeavesSum(Node root) {
    if (root == null) {
      return 0;
    }

    dfs(root, 0);
    return levelSums.get(levelSums.size() - 1);
  }

  private void dfs(Node node, int level) {
    if (node == null) {
      return;
    }

    if (levelSums.size() == level) {
      levelSums.add(node.value);
    } else {
      levelSums.set(level, levelSums.get(level) + node.value);
    }

    dfs(node.left, level + 1);
    dfs(node.right, level + 1);
  }
}
