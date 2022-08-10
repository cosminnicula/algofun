package dev.intermediatebox.hashtable;

import dev.intermediatebox.list.utils.DoublyLinkedListNode;

import java.util.HashMap;

public class LRUCache {
  public static void main(String[] args) {

    Solution s = new Solution(2);
    s.put(1, 1);
    s.put(2, 2);
    System.out.println(s.get(1));
    s.put(3, 3);
    System.out.println(s.get(2));
    s.put(4, 4);
    System.out.println(s.get(1));
    System.out.println(s.get(3));
    System.out.println(s.get(4));
  }

  // Tag: HashTable
  // Tag: LinkedList

  // O(1) time complexity for get and put
  // O(capacity) space complexity
  private static class Solution {
    int capacity;

    HashMap<Integer, DoublyLinkedListNode> cacheMap;

    // bounds the least recently used list -> towards the head are older items, while towards the tail are more recent items
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    public Solution(int capacity) {
      this.capacity = capacity;

      this.cacheMap = new HashMap<>();
      this.head = new DoublyLinkedListNode(-1);
      this.tail = new DoublyLinkedListNode(-1);

      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      // get value
      if (!cacheMap.containsKey(key)) {
        return -1;
      }

      DoublyLinkedListNode node = cacheMap.get(key);

      // add the currently accessed element to the end of the list (tail) for marking it as the most recent accessed element
      // first, unlink the element from the list
      unlinkNode(node);

      // second, link the element to the end of the list
      linkNodeToEnd(node);

      return node.value;
    }

    public void put(int key, int value) {
      // if the element is found in the cache, unlink it from the list
      if (cacheMap.containsKey(key)) {
        unlinkNode(cacheMap.get(key));
      }

      // put element in the cache
      cacheMap.put(key, new DoublyLinkedListNode(value));
      // link the element to the end of the list
      linkNodeToEnd(cacheMap.get(key));

      // if cache exceeds capacity, remove from cache and from the list the first element, which is the oldest
      if (cacheMap.size() > this.capacity) {
        cacheMap.remove(head.next.value);
        unlinkNode(head.next);
      }
    }

    private void unlinkNode(DoublyLinkedListNode node) {
      DoublyLinkedListNode previous = node.prev;
      DoublyLinkedListNode next = node.next;
      previous.next = next;
      next.prev = previous;
    }

    private void linkNodeToEnd(DoublyLinkedListNode node) {
      DoublyLinkedListNode tailPrevious = tail.prev;
      tail.prev = node;
      node.prev = tailPrevious;

      tailPrevious.next = node;
      node.next = tail;
    }
  }
}
