package dev.intermediatebox.stack;
//Tag: Stack

import java.util.Stack;

// O(1) time complexity for all operations
// O(n) space complexity (for the two stacks)
public class MinStack {
  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
    this.stack = new Stack<>();
    this.minStack = new Stack<>();
  }

  public void push(int val) {
    if (this.minStack.isEmpty()) {
      this.minStack.push(val);
    } else {
      this.minStack.push(val < this.minStack.peek() ? val : this.minStack.peek());
    }

    this.stack.push(val);
  }

  public void pop() {
    this.stack.pop();
    this.minStack.pop();
  }

  public int top() {
    return this.stack.peek();
  }

  public int getMin() {
    return this.minStack.peek();
  }
}
