package dev.intermediatebox.concepts.recursion;

public class ProductOfArray {
  public static void main(String[] args) {
    ProductOfArray productOfArray = new ProductOfArray();
    int[] array = new int[]{2, 2, 5};
    var solution = productOfArray.recursion(array, array.length);
    System.out.println(solution);
  }

  private int recursion(int[] array, int index) {
    if (index < 1) {
      return 1;
    }

    return array[index - 1] * recursion(array, index - 1);
  }
}
