package dev.intermediatebox.concepts.recursion;

class DecimalToBinary {
  public static void main(String[] args) {
    DecimalToBinary decimalToBinary = new DecimalToBinary();
    var solution = decimalToBinary.recursion(4);
    System.out.println(solution);

  }

  private int recursion(int n) {
    if (n == 0) {
      return 0;
    }
    return n % 2 + 10 * recursion(n / 2);
  }
}
