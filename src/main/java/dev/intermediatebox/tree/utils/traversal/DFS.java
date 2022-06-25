package dev.intermediatebox.tree.utils.traversal;

import dev.intermediatebox.tree.utils.Node;

import java.util.List;

public class DFS {

  // OBS: inorder traversal of BST is an array sorted in the ascending order
  public static void inorder(Node root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    inorder(root.left, traversal);
    traversal.add(root.value);
    inorder(root.right, traversal);
  }

  public static void preorder(Node root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    traversal.add(root.value);
    preorder(root.left, traversal);
    preorder(root.right, traversal);
  }

  public static void postorder(Node root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    preorder(root.left, traversal);
    preorder(root.right, traversal);
    traversal.add(root.value);
  }
}
