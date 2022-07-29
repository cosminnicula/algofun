package dev.intermediatebox.concepts.recursion;

public class RecursiveRange {
  public static void main(String[] args) {
    RecursiveRange recursiveRange = new RecursiveRange();
    var solution = recursiveRange.recursion(5);
    System.out.println(solution);
  }

  private int recursion(int current) {
    if (current <= 0) {
      return 0;
    }

    return current + recursion(current - 1);
  }
}
