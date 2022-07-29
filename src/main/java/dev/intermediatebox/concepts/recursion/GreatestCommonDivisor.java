package dev.intermediatebox.concepts.recursion;

class GreatestCommonDivisor {
  public static void main(String[] args) {
    GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
    var solution = greatestCommonDivisor.recursion(16, 32);
    System.out.println(solution);
  }

  private int recursion(int a, int b) {
    if (a < 0 || b < 0) {
      return -1;
    }
    if (b == 0) {
      return a;
    }
    return recursion(b, a % b);
  }
}
