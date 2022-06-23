package dev.intermediatebox.string;

import dev.intermediatebox.string.utils.Node;

import java.util.ArrayList;
import java.util.List;
// Tag: Tree
// Tag: Recursion

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
