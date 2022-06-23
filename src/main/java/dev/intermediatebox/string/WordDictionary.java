package dev.intermediatebox.string;
// Tag: String
// Tag: Trie

import dev.intermediatebox.string.utils.TrieCharNode2;

// Design a data structure that supports adding new words and finding if a string matches any previously added string.

//Implement the WordDictionary class:
//
//WordDictionary() Initializes the object.
//void addWord(word) Adds word to the data structure, it can be matched later.
//bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

public class WordDictionary {
  private TrieCharNode2 root;

  public WordDictionary() {
    this.root = new TrieCharNode2();
  }

  public void addWord(String word) {
    TrieCharNode2 node = this.root;

    for (char c : word.toCharArray()) {
      if (!node.children.containsKey(c)) {
        node.children.put(c, new TrieCharNode2());
      }

      node = node.children.get(c);
    }

    node.isWord = true;
  }

  public boolean search(String word) {
    return searchInNode(word, this.root);
  }

  private boolean searchInNode(String word, TrieCharNode2 node) {
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!node.children.containsKey(c)) {
        if (c != '.') {
          return false;
        }

        for (TrieCharNode2 child : node.children.values()) {
          if (searchInNode(word.substring(i + 1), child)) {
            return true;
          }
        }
      } else {
        node = node.children.get(c);
      }
    }

    return node.isWord;
  }
}
