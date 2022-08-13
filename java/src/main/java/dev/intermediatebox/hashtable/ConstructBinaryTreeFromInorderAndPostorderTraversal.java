package dev.intermediatebox.hashtable;

import dev.intermediatebox.tree.utils.Traversal.DFSRecursive;
import dev.intermediatebox.tree.utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
  public static void main(String[] args) {
    Solution s = new Solution();

    int[] postorder = new int[]{9, 15, 7, 20, 3};
    int[] inorder = new int[]{9, 3, 15, 20, 7};

    TreeNode root = s.buildTree(inorder, postorder);

    List<Integer> traversal = new LinkedList<>();
    DFSRecursive.inorder(root, traversal);

    System.out.println(traversal);
  }

  private static class Solution {
    private HashMap<Integer, Integer> inorderMap;
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
      inorderMap = new HashMap<>();
      postorderIndex = postorder.length - 1;

      // build index+value hashmap
      for (int i = 0; i < inorder.length; i++) {
        inorderMap.put(inorder[i], i);
      }

      return buildTreeHelper(postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int start, int end) {
      if (start > end) {
        return null;
      }

      int rootValue = postorder[postorderIndex];
      postorderIndex -= 1;
      TreeNode root = new TreeNode(rootValue);

      int inorderIndex = inorderMap.get(rootValue);

      root.right = buildTreeHelper(postorder, inorderIndex + 1, end);
      root.left = buildTreeHelper(postorder, start, inorderIndex - 1);

      return root;
    }
  }
}
