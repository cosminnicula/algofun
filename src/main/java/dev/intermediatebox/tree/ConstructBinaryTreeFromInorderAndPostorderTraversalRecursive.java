package dev.intermediatebox.tree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursive

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

// O(n) time complexity
// O(n) space complexity
public class ConstructBinaryTreeFromInorderAndPostorderTraversalRecursive {
  int[] postorder;
  int[] inorder;

  Map<Integer, Integer> inorderIndexes = new HashMap<>();

  int postorderIndex;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
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

  private TreeNode reconstructTree(int inorderLeft, int inorderRight) {
    if (inorderLeft > inorderRight) {
      return null;
    }

    int rootValue = postorder[postorderIndex];
    TreeNode root = new TreeNode(rootValue);

    // the root value splits inorder list into left and right subtrees
    int inorderIndex = inorderIndexes.get(rootValue);

    postorderIndex--;
    // right subtree
    root.right = reconstructTree(inorderIndex + 1, inorderRight);

    // left subtree
    root.left = reconstructTree(inorderLeft, inorderIndex - 1);

    return root;
  }
}
