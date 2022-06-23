package dev.intermediatebox.string.utils;

import java.util.HashMap;
import java.util.Map;

// Map of TrieCharNode2
public class TrieCharNode2 {
  public Map<Character, TrieCharNode2> children;

  public boolean isWord;

  public TrieCharNode2() {
    this.children = new HashMap<>();
  }
}
