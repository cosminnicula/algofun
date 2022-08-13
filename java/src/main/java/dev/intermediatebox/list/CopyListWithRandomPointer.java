package dev.intermediatebox.list;

import dev.intermediatebox.list.utils.ListNodeRandom;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
  public static void main(String[] args) {
    ListNodeRandom n1 = new ListNodeRandom(7);
    ListNodeRandom n2 = new ListNodeRandom(13);
    ListNodeRandom n3 = new ListNodeRandom(11);
    ListNodeRandom n4 = new ListNodeRandom(10);
    ListNodeRandom n5 = new ListNodeRandom(1);

    n1.next = n2;
    n1.random = null;
    n2.next = n3;
    n2.random = n1;
    n3.next = n4;
    n3.random = n5;
    n4.next = n5;
    n4.random = n3;
    n5.next = null;
    n5.random = n1;

    // O(n) space complexity
    Solution1 s1 = new Solution1();

    ListNodeRandom clonedHead = s1.copyRandomList(n1);

    ListNodeRandom current = clonedHead;
    while (current != null) {
      System.out.println(current.value + "," + (current.random != null ? current.random.value : "null"));
      current = current.next;
    }

    // O(1) space complexity
    Solution2 s2 = new Solution2();
    clonedHead = s2.copyRandomList(n1);

    current = clonedHead;
    while (current != null) {
      System.out.println(current.value + "," + (current.random != null ? current.random.value : "null"));
      current = current.next;
    }
  }

  // Tag: HashTable
  // Tag: LinkedList

  // O(n) time complexity
  // O(n) space complexity
  private static class Solution1 {
    public ListNodeRandom copyRandomList(ListNodeRandom head) {
      if (head == null) {
        return null;
      }

      Map<ListNodeRandom, ListNodeRandom> clonedMap = new HashMap<>();

      // first pass: creates the hashmap with key: original ListNodeRandom, and value: cloned ListNodeRandom
      ListNodeRandom current = head;
      while (current != null) {
        clonedMap.put(current, new ListNodeRandom(current.value));
        current = current.next;
      }

      // second pass: for each original ListNodeRandom, set cloned ListNodeRandom's next and random pointers to whatever cloned ListNodeRandom the original ListNodeRandom points to
      for (ListNodeRandom original : clonedMap.keySet()) {
        ListNodeRandom clone = clonedMap.get(original);

        clone.next = clonedMap.get(original.next);
        clone.random = clonedMap.get(original.random);
      }

      return clonedMap.get(head);
    }
  }

  // O(n) time complexity
  // O(1) space complexity
  private static class Solution2 {
    public ListNodeRandom copyRandomList(ListNodeRandom head) {
      if (head == null) {
        return null;
      }

      // TODO: implementation

      return null;
    }
  }
}
