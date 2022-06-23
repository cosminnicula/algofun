package dev.intermediatebox;
// Tag: String
// Tag: Stack

//Given a string s represents the serialization of a nested list, implement a parser to deserialize it and return the deserialized NestedInteger.
//
//Each element is either an integer or a list whose elements may also be integers or other lists.


import dev.intermediatebox.utils.NestedInteger;

import java.util.Stack;

// Input: s = "[123,[456,[789]]]", Output: [123,[456,[789]]]
public class MiniParser {
  public NestedInteger deserialize(String s) {
    if (!s.contains("[")) {
      return new NestedInteger(Integer.valueOf(s));
    }

    Stack<NestedInteger> stack = new Stack<>();

    // root NestedInteger
    NestedInteger root = new NestedInteger();
    stack.push(root);

    NestedInteger number = null;
    for (int i = 0; i < s.length() - 1; i++) {
      char c = s.charAt(i);
      if (c == '[') {
        NestedInteger ni = new NestedInteger();

        if (!stack.empty()) {
          stack.peek().add(ni);
        }

        stack.push(ni);
      } else if (c >= '0' && c <= '9') {
        if (number == null) {
          number = new NestedInteger(0);
          stack.peek().add(number);
        }

        number.setInteger(number.getInteger() * 10 + c - '0');
      } else if (c == ',') {
        number = null;
      } else { // ']'
        stack.pop();
        number = null;
      }
    }

    return stack.pop(); // return root NestedInteger
  }
}

