package dev.intermediatebox.tree.utils.Traversal;

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSIterative {
  public static void traverse(TreeNode root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      traversal.add(node.value);

      if(node.left != null) {
        queue.add(node.left);
      }

      if(node.right != null) {
        queue.add(node.right);
      }
    }
  }
}
