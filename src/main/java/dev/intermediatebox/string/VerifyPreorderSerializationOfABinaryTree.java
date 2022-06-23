package dev.intermediatebox.string;
// Tag: String
// Tag: Stack
// Tag: Tree
// Tag: BinaryTree

// One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'.
//For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
//
//Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.
//
//It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.
//
//You may assume that the input format is always valid.
//
//For example, it could never contain two consecutive commas, such as "1,,3".
//
//Note: You are not allowed to reconstruct the tree.


//// O(n) time complexity
//// O(n) space complexity (in-memory split array)
//public class VerifyPreorderSerializationOfABinaryTree {
//  public boolean isValidSerialization(String preorder) {
//    int sum = 1;
//
//    for (String slot: preorder.split(",")) {
//      sum -= 1;
//
//      if (sum < 0) {
//        return  false;
//      }
//
//      if (!slot.equals("#")) {
//        sum += 2;
//      }
//    }
//
//    return sum == 0;
//  }
//}


// O(n) time complexity
// O(1) space complexity
public class VerifyPreorderSerializationOfABinaryTree {
  public boolean isValidSerialization(String preorder) {
    int sum = 1;

    for (int i = 0; i < preorder.length(); i++) {
      if (preorder.charAt(i) == ',') {
        sum -= 1;

        if (sum < 0) {
          return false;
        }

        if (preorder.charAt(i - 1) != '#') {
          sum += 2;
        }
      }
    }

    if (preorder.charAt(preorder.length() - 1) == '#') {
      sum -= 1;
    } else {
      sum += 1;
    }

    return sum == 0;
  }
}