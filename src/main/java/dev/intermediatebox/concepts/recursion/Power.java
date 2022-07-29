package dev.intermediatebox.concepts.recursion;

class Power {
  public static void main(String[] args) {
    Power power = new Power();
    var solution = power.recursion(2, 4);
    System.out.println(solution);
  }

  private int recursion(int base, int exp) {
    if (exp < 0) {
      return -1;
    }
    if (exp == 0 || exp == 1) {
      return base;
    }
    return base * recursion(base, exp - 1);
  }
}
