package dev.intermediatebox;

import dev.intermediatebox.utils.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeDepthFirstTraversal {
  List<Integer> traversed = new ArrayList<>();

  public List<Integer> run(Node head) {
    if (head == null) {
      return traversed;
    }

    depthFirst(head);
    return traversed;
  }

  // left-right-root
  private void depthFirst(Node node) {
    if (node == null) {
      return;
    }

    depthFirst(node.left);
    depthFirst(node.right);
    traversed.add(node.value);
  }
}
