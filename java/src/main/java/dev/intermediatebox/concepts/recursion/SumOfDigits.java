package dev.intermediatebox.concepts.recursion;

class SumOfDigits {
  public static void main(String[] args) {
    SumOfDigits sumOfDigits = new SumOfDigits();
    var solution = sumOfDigits.recursion(123);
    System.out.println(solution);
  }

  private int recursion(int n) {
    if (n == 0 || n < 0) {
      return 0;
    }
    return n % 10 + recursion(n / 10);
  }
}
