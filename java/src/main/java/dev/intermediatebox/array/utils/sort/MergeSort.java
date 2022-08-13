package dev.intermediatebox.array.utils.sort;

public class MergeSort {

  public static void sort(int[] array) {
    if (array.length == 0) {
      return;
    }

    ms(array);
  }

  private static void ms(int[] array) {
    if (array.length < 2) {
      return;
    }

    int size = array.length;
    int middle = size / 2;
    int[] left = new int[middle];
    int[] right = new int[size - middle];

    for (int i = 0; i < middle; i++) {
      left[i] = array[i];
    }

    for (int i = middle; i < size; i++) {
      right[i - middle] = array[i];
    }

    ms(left);
    ms(right);

    merge(array, left, right);
  }

  private static void merge(int[] merged, int[] left, int[] right) {
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        merged[k++] = left[i++];
      } else {
        merged[k++] = right[j++];
      }
    }

    while (i < left.length) {
      merged[k++] = left[i++];
    }

    while (j < right.length) {
      merged[k++] = right[j++];
    }
  }
}
