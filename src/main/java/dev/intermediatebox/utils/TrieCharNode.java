package dev.intermediatebox.utils;

// Array of TrieCharNode
public class TrieCharNode {
  private final int maxChildren = 26;

  private TrieCharNode[] children;

  private boolean isWord = false;

  public TrieCharNode() {
    this.children = new TrieCharNode[maxChildren];
  }

  public boolean exists(Character c) {
    return children[c - 'a'] != null;
  }

  public TrieCharNode get(Character c) {
    return children[c - 'a'];
  }

  public void put(Character c) {
    children[c - 'a'] = new TrieCharNode();
  }

  public void setIsWord() {
    this.isWord = true;
  }

  public boolean getIsWord() {
    return this.isWord;
  }
}
