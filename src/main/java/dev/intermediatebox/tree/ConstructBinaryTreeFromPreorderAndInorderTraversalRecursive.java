package dev.intermediatebox.tree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.Node;

import java.util.HashMap;
import java.util.Map;

// O(n) time complexity
// O(n) space complexity
public class ConstructBinaryTreeFromPreorderAndInorderTraversalRecursive {
  int[] preorder;
  int[] inorder;

  Map<Integer, Integer> inorderIndexes = new HashMap<>();

  int preorderIndex;

  public Node buildTree(int[] inorder, int[] preorder) {
    this.preorder = preorder;
    this.inorder = inorder;

    int inorderIndex = 0;
    for (Integer i: inorder) {
      inorderIndexes.put(i, inorderIndex);
      inorderIndex++;
    }

    preorderIndex = 0;

    return reconstructTree(0, preorder.length - 1);
  }

  private Node reconstructTree(int inorderLeft, int inorderRight) {
    if (inorderLeft > inorderRight) {
      return null;
    }

    int rootValue = preorder[preorderIndex];
    Node root = new Node(rootValue);

    // the root value splits inorder list into left and right subtrees
    int inorderIndex = inorderIndexes.get(rootValue);

    preorderIndex++;
    // left subtree
    root.left = reconstructTree(inorderLeft, inorderIndex - 1);

    // right subtree
    root.right = reconstructTree(inorderIndex + 1, inorderRight);

    return root;
  }
}
