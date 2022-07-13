package dev.intermediatebox.tree.BinaryTreeRightSideView;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// O(n) time complexity (the nodes are visited only once)
// O(n) space complexity (worst case is when recursion stack is equal to the number of nodes)
public class BinaryTreeRightSideViewRecursiveDFS {
  List<Integer> rightSide = new ArrayList();

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return rightSide;
    }

    dfs(root, 0);

    return rightSide;
  }

  // this is actually DSF with recursive reverse preorder
  private void dfs(TreeNode node, int level) {
    if (level == rightSide.size()) {
      rightSide.add(node.value);
    }

    if (node.right != null) {
      dfs(node.right, level + 1);
    }

    if (node.left != null) {
      dfs(node.left, level + 1);
    }
  }
}
