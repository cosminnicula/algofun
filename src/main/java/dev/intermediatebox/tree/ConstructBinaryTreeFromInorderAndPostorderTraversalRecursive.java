package dev.intermediatebox.tree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.Node;

import java.util.HashMap;
import java.util.Map;

// O(n) time complexity
// O(n) space complexity
public class ConstructBinaryTreeFromInorderAndPostorderTraversalRecursive {
  int[] postorder;
  int[] inorder;

  Map<Integer, Integer> inorderIndexes = new HashMap<>();

  int postorderIndex;

  public Node buildTree(int[] inorder, int[] postorder) {
    this.postorder = postorder;
    this.inorder = inorder;

    int inorderIndex = 0;
    for (Integer i: inorder) {
      inorderIndexes.put(i, inorderIndex);
      inorderIndex++;
    }

    postorderIndex = postorder.length - 1;

    return reconstructTree(0, inorder.length - 1);
  }

  private Node reconstructTree(int inorderLeft, int inorderRight) {
    if (inorderLeft > inorderRight) {
      return null;
    }

    int rootValue = postorder[postorderIndex];
    Node root = new Node(rootValue);

    // the root value splits inorder list into left and right subtrees
    int index = inorderIndexes.get(rootValue);

    postorderIndex--;
    // right subtree
    root.right = reconstructTree(index + 1, inorderRight);

    // left subtree
    root.left = reconstructTree(inorderLeft, index - 1);

    return root;
  }
}
