package dev.intermediatebox.tree.BinaryTreeLevelOrderTraversal;
// Tag: Tree
// Tag: BinaryTree
// Tag: Iterative

import dev.intermediatebox.tree.utils.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// O(n) time complexity
// O(n) space complexity
public class BinaryTreeLevelOrderTraversalIterative {
  List<List<Integer>> levels = new ArrayList<List<Integer>>();

  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return levels;
    }

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    int level = 0;

    while (!queue.isEmpty()) {
      levels.add(new ArrayList<Integer>());

      int levelSize = queue.size();
      for (int i = 0; i < levelSize; ++i) {
        Node node = queue.remove();

        levels.get(level).add(node.value);

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }

      level++;
    }

    return levels;
  }
}
