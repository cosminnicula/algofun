package dev.intermediatebox.tree.utils.traversal;

import dev.intermediatebox.tree.utils.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSIterative {
  public static void traverse(Node root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();

    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.poll();
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
