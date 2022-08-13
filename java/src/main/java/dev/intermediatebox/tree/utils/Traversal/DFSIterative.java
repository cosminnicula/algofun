package dev.intermediatebox.tree.utils.Traversal;

import dev.intermediatebox.tree.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DFSIterative {
  // left -> node -> right
  public static void inorder(TreeNode root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    Deque<TreeNode> stack = new LinkedList<>();

    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      node = stack.pop();
      traversal.add(node.value);

      node = node.right;
    }
  }

  // node -> left -> right
  public static void preorder(TreeNode root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    Deque<TreeNode> stack = new LinkedList<>();

    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      traversal.add(node.value);

      if(node.right != null){
        stack.push(node.right);
      }

      if(node.left != null){
        stack.push(node.left);
      }
    }
  }

  // left -> right -> node
  public static void postorder(TreeNode root, List<Integer> traversal) {
    Deque<TreeNode> stack1 = new LinkedList<>();
    Deque<TreeNode> stack2 = new LinkedList<>();

    stack1.push(root);
    while (!stack1.isEmpty()) {
      // insert root into second stack
      TreeNode node = stack1.pop();
      stack2.push(node);

      // insert left and right nodes to first stack
      if(node.left!=null){
        stack1.push(node.left);
      }
      if(node.right!=null){
        stack1.push(node.right);
      }
    }

    while(!stack2.isEmpty()){
      traversal.add(stack2.pop().value);
    }
  }
}
