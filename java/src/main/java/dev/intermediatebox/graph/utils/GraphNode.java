package dev.intermediatebox.graph.utils;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
  public int value;
  public List<GraphNode> neighbors;

  public GraphNode() {
    value = 0;
    neighbors = new ArrayList<>();
  }

  public GraphNode(int value) {
    this.value = value;
    neighbors = new ArrayList<>();
  }

  public GraphNode(int value, ArrayList<GraphNode> neighbors) {
    this.value = value;
    this.neighbors = neighbors;
  }
}
