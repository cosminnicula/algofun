package dev.intermediatebox.string;
// Tag: Tree
// Tag: Queue

import dev.intermediatebox.string.utils.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBreadthFirstTraversal {
  List<Integer> traversed = new ArrayList<>();

  public List<Integer> run(Node head) {
    if (head == null) {
      return traversed;
    }

    breadthFirst(head);

    return traversed;
  }

  private void breadthFirst(Node head) {
    Queue<Node> queue = new LinkedList<>();

    queue.add(head);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      traversed.add(node.value);

      if(node.left != null) {
        queue.add(node.left);
      }

      if(node.right != null) {
        queue.add(node.right);
      }
    }
  }
}
