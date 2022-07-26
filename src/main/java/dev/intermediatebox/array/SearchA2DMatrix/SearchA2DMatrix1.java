package dev.intermediatebox.array.SearchA2DMatrix;
// Tag: Array
// Tag: Matrix
// Tag: Binary Search

// integers in each row are sorted from left to right
// the first integer of each row is greater than the last integer of the previous row

// O(log(m*n)) time complexity
// O(1) space complexity
public class SearchA2DMatrix1 {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;

    int left = 0;
    int right = rows * cols - 1;

    while (left <= right) {
      int mid1D = left + (right - left) / 2;
      // convert 1D index to 2D index
      int mid2D = matrix[mid1D / cols][mid1D % cols];

      if (target == mid2D) {
        return true;
      } else if (target > mid2D) {
        left = mid2D + 1;
      } else {
        right = mid2D - 1;
      }
    }

    return false;
  }
}
