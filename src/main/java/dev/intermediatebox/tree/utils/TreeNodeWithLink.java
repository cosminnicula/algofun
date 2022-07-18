package dev.intermediatebox.tree.utils;

public class TreeNodeWithLink {
  public int value;
  public TreeNodeWithLink left;
  public TreeNodeWithLink right;
  public TreeNodeWithLink next;

  public TreeNodeWithLink(int value) {
    this.value = value;
  }

  public TreeNodeWithLink(int value, TreeNodeWithLink left, TreeNodeWithLink right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}
