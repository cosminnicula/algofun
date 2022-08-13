package dev.intermediatebox.stack;

import dev.intermediatebox.string.utils.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlattenNestedListIterator {
  public static void main(String[] args) {
    // [[1,1],2,[1,1]]
    List<NestedInteger> l = List.of(
        new NestedInteger(List.of(new NestedInteger(1), new NestedInteger(1))),
        new NestedInteger(2),
        new NestedInteger(List.of(new NestedInteger(1), new NestedInteger(1)))
    );

    NestedIterator n = new NestedIterator(l);
    while (n.hasNext()) {
      System.out.println(n.next());
    }
  }

  // Tag: Stack

  // O(n) time complexity
  // O(n) space complexity
  private static class NestedIterator implements Iterator<Integer> {
    private List<Integer> flattened = new LinkedList<>();

    private Integer index = 0;

    // Flatten the list of NestedIntegers recursively
    // The list of NestedIntegers can be seen as a list of individual graphs. Each graph is traversed recursively.
    public NestedIterator(List<NestedInteger> nestedList) {
      for (NestedInteger nestedInteger: nestedList) {
        flatten(nestedInteger);
      }
    }

    // Recursively traverse the graph (nestedInteger.getList() is the adjacency list)
    private void flatten(NestedInteger nestedInteger) {
      if (nestedInteger.isInteger()) {
        flattened.add(nestedInteger.getInteger());
        return;
      }

      for (NestedInteger innerNestedInteger: nestedInteger.getList()) {
        flatten(innerNestedInteger);
      }
    }

    @Override
    public Integer next() {
      Integer value = flattened.get(index);
      index += 1;
      return value;
    }

    @Override
    public boolean hasNext() {
      return index < flattened.size();
    }
  }

}
