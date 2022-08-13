package dev.intermediatebox.concepts.recursion;

class Fibonacci {
  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci();
    var solution = fibonacci.recursion(5);
    System.out.println(solution);
  }

  private int recursion(int n) {
    if (n < 0) {
      return -1;
    }
    if (n == 0 || n == 1) {
      return n;
    }
    return recursion(n - 1) + recursion(n - 2);
  }
}
