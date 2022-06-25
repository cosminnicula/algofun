package dev.intermediatebox.tree.RecoverBinarySearchTree;
// Tag: Tree
// Tag: BinaryTree
// Tag: Recursion

import dev.intermediatebox.tree.utils.Node;
import dev.intermediatebox.tree.utils.traversal.DFS;

import java.util.ArrayList;
import java.util.List;

// O(n) time complexity
// O(n) space complexity (the size of the traversal array)
public class RecoverBinarySearchTreeSort {

  private List<Integer> getSwappedValues(List<Integer> traversal) {
    List<Integer> swappedValues = new ArrayList<>();
    swappedValues.add(-1);
    swappedValues.add(-1);
    boolean wasSwapped = false;

    for (int i = 0; i < traversal.size() - 1; i++) {
      if (traversal.get(i) > traversal.get(i + 1)) {
        if (!wasSwapped) {
          swappedValues.set(0, traversal.get(i));
          swappedValues.set(1, traversal.get(i + 1));
          wasSwapped = true;
        } else {
          break;
        }
      }
    }

    return swappedValues;
  }

  private void recover(Node node, Integer swapCounter, Integer val1, Integer val2) {
    if (node == null) {
      return;
    }

    if (swapCounter == 0) {
      return;
    }

    if (node.value == val1 || node.value == val2) {
      node.value = node.value == val1 ? val2 : val1;
      swapCounter--;
    }

    recover(node.left, swapCounter, val1, val2);
    recover(node.right, swapCounter, val1, val2);
  }

  public void recoverTree(Node root) {
    List<Integer> traversal = new ArrayList<>();

    DFS.inorder(root, traversal);

    List<Integer> swappedValues = getSwappedValues(traversal);

    recover(root, 2, swappedValues.get(0), swappedValues.get(1));
  }
}
