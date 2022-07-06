package dev.intermediatebox.tree.utils.traversal;

import dev.intermediatebox.tree.utils.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DFSIterative {
  // left -> node -> right
  public static void inorder(Node root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    Deque<Node> stack = new LinkedList<>();

    Node node = root;
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
  public static void preorder(Node root, List<Integer> traversal) {
    if (root == null) {
      return;
    }

    Deque<Node> stack = new LinkedList<>();

    stack.push(root);
    while (!stack.isEmpty()) {
      Node node = stack.pop();
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
  public static void postorder(Node root, List<Integer> traversal) {
    Deque<Node> stack1 = new LinkedList<>();
    Deque<Node> stack2 = new LinkedList<>();

    stack1.push(root);
    while (!stack1.isEmpty()) {
      // insert root into second stack
      Node node = stack1.pop();
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
