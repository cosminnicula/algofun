package dev.intermediatebox.tree.utils.traversal;

import dev.intermediatebox.tree.utils.Node;

import java.util.List;

public class DFSRecursive {

  // OBS: inorder traversal of BST is an array sorted in the ascending order
  // left -> node -> right
  public static void inorder(Node root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    inorder(root.left, traversal);
    traversal.add(root.value);
    inorder(root.right, traversal);
  }

  // node -> left -> right
  public static void preorder(Node root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    traversal.add(root.value);
    preorder(root.left, traversal);
    preorder(root.right, traversal);
  }

  // node -> right -> left
  public static void reversePreorder(Node root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    traversal.add(root.value);
    preorder(root.right, traversal);
    preorder(root.left, traversal);
  }

  // left -> right -> node
  public static void postorder(Node root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    postorder(root.left, traversal);
    postorder(root.right, traversal);
    traversal.add(root.value);
  }
}
