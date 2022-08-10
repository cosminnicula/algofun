package dev.intermediatebox.list.utils;

public class ListNodeRandom {
  public int value;
  public ListNodeRandom next;
  public ListNodeRandom random;

  public ListNodeRandom() {
  }

  public ListNodeRandom(int value) {
    this.value = value;
  }

  ListNodeRandom(int value, ListNodeRandom next, ListNodeRandom random) {
    this.value = value;
    this.next = next;
    this.random = random;
  }
}