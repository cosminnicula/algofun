package dev.intermediatebox.graph.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Traversal {
  public static void dfs(GraphNode node, List<Integer> traversal) {
    if (node == null) {
      return;
    }

    Set<Integer> seen = new HashSet<>();

    dfs_helper(node, traversal, seen);
  }

  private static void dfs_helper(GraphNode node, List<Integer> traversal, Set<Integer> seen) {
    if (node == null) {
      return;
    }

    if (seen.contains(node.value)) {
      return;
    }

    seen.add(node.value);
    traversal.add(node.value);

    for (GraphNode neighbor : node.neighbors) {
        dfs_helper(neighbor, traversal, seen);
    }
  }
}
