package dev.intermediatebox;
// Tag: String
// Tag: Trie
// Tag: HashTable

import dev.intermediatebox.utils.TrieCharNode;

// insert:
// O(n) time complexity, where n is the size of the word
// O(n) space complexity (when the word contains only distinct characters)
// search:
// O(n) time complexity
// O(1) space complexity
// prefix search:
// O(n) time complexity
// O(1) space complexity

public class TriePrefixTree {
  private TrieCharNode root;

  public TriePrefixTree() {
    this.root = new TrieCharNode();
  }

  public void insert(String word) {
    TrieCharNode node = this.root;

    for (char c: word.toCharArray()) {
      if (!node.exists(c)) {
        node.put(c);
      }

      node = node.get(c);
    }

    node.setIsWord();
  }

  public boolean search(String word) {
    TrieCharNode node = this.root;

    for (char c: word.toCharArray()) {
      if (!node.exists(c)) {
        return false;
      }

      node = node.get(c);
    }

    return node.getIsWord();
  }

  public boolean startsWith(String prefix) {
    TrieCharNode node = this.root;

    for (char c: prefix.toCharArray()) {
      if (!node.exists(c)) {
        return false;
      }

      node = node.get(c);
    }

    return true;
  }
}
