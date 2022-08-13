package dev.intermediatebox.hashtable;

import dev.intermediatebox.tree.utils.Traversal.DFSRecursive;
import dev.intermediatebox.tree.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
  public static void main(String[] args) {
    Solution s = new Solution();

    int[] preorder = new int[]{3, 9, 20, 15, 7};
    int[] inorder = new int[]{9, 3, 15, 20, 7};

    TreeNode root = s.buildTree(preorder, inorder);

    List<Integer> traversal = new LinkedList<>();
    DFSRecursive.inorder(root, traversal);

    System.out.println(traversal);
  }

  private static class Solution {
    private HashMap<Integer, Integer> inorderMap;
    int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      inorderMap = new HashMap<>();
      preorderIndex = 0;

      // build index+value hashmap
      for (int i = 0; i < inorder.length; i++) {
        inorderMap.put(inorder[i], i);
      }

      return buildTreeHelper(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int start, int end) {
      if (start > end) {
        return null;
      }

      int rootValue = preorder[preorderIndex];
      preorderIndex += 1;
      TreeNode root = new TreeNode(rootValue);

      int inorderIndex = inorderMap.get(rootValue);

      // elements in the preorder array between start and split point - 1 represents the left part of the array
      root.left = buildTreeHelper(preorder, start, inorderIndex - 1);
      // elements in the preorder array between split point + 1 and end represents the right part of the array
      root.right = buildTreeHelper(preorder, inorderIndex + 1, end);

      return root;
    }
  }
}
