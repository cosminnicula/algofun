package dev.intermediatebox.concepts.recursion;

class Factorial {
  public static void main(String[] args) {
    Factorial factorial = new Factorial();
    var solution = factorial.recursion(5);
    System.out.println(solution);
  }

  private int recursion(int n) {
    if (n < 1) {
      return -1;
    }
    if (n == 0 || n == 1) {
      return 1;
    }
    return n * recursion(n - 1);
  }
}
