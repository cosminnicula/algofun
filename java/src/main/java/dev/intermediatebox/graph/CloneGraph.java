package dev.intermediatebox.graph;

import dev.intermediatebox.graph.utils.GraphNode;
import dev.intermediatebox.graph.utils.Traversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {
  public static void main(String[] args) {
    GraphNode node1 = new GraphNode(1);
    GraphNode node2 = new GraphNode(2);
    GraphNode node3 = new GraphNode(3);
    GraphNode node4 = new GraphNode(4);

    node1.neighbors.add(node2);
    node1.neighbors.add(node4);
    node2.neighbors.add(node1);
    node2.neighbors.add(node3);
    node3.neighbors.add(node2);
    node3.neighbors.add(node4);
    node4.neighbors.add(node1);
    node4.neighbors.add(node3);

    List<Integer> traversal = new LinkedList<>();
    Traversal.dfs(node1, traversal);

    System.out.println(traversal);
  }

  // Tag: HashTable
  // Tag: Graph

  // O(n) time complexity
  // O(n) space complexity
  private static class Solution {
    private HashMap<Integer, GraphNode> seen;

    public GraphNode cloneGraph(GraphNode node) {
      if (node == null) {
        return null;
      }

      seen = new HashMap<>();

      return clone(node);
    }

    private GraphNode clone(GraphNode node) {
      // base condition: if value is seen, then get the GraphNode associated with that value and return
      if (seen.containsKey(node.value)) {
        return seen.get(node.value);
      }

      // if value is not seen, then add <value, new GraphNode(value)> to the Map
      GraphNode cloned = new GraphNode(node.value);
      seen.put(node.value, cloned);

      // iterate the neighbors of the original node and add a clone of them to the neighbors of the cloned GraphNode found in the Map
      for (GraphNode neighbor: node.neighbors) {
        cloned.neighbors.add(clone(neighbor));
      }

      return cloned;
    }
  }
}
