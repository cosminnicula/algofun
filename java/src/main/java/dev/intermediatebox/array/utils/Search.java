package dev.intermediatebox.array.utils;

public class Search {
  // O(logn) time complexity
  // O(1) space complexity
  public static int binarySearchIterative(int[] sortedArray, int value) {
    if (sortedArray.length == 0) {
      return -1;
    }

    int left = 0;
    int right = sortedArray.length - 1;

    while (left <= right) {
      // computing middle via "(left + right) / 2" would cause overflow when left + right > max int
      int middle = left + (right - left) / 2;
      if (value > sortedArray[middle]) {
        left = middle + 1;
      } else if (value < sortedArray[middle]) {
        right = middle - 1;
      } else {
        return middle;
      }
    }

    return -1;
  }

  // O(logn) time complexity
  // O(n) space complexity
  public static int binarySearchRecursive(int[] sortedArray, int value) {
    if (sortedArray.length == 0) {
      return -1;
    }

    int left = 0;
    int right = sortedArray.length - 1;

    return bsr(sortedArray, value, left, right);
  }

  private static int bsr(int[] sortedArray, int value, int left, int right) {
    if (left > right) {
      return -1;
    }

    int middle = left + (right - left) / 2;
    if (value > sortedArray[middle]) {
      return bsr(sortedArray, value, middle + 1, right);
    } else if (value < sortedArray[middle]) {
      return bsr(sortedArray, value, left, middle - 1);
    } else {
      return middle;
    }
  }
}
