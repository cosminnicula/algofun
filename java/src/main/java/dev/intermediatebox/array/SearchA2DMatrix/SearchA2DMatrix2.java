package dev.intermediatebox.array.SearchA2DMatrix;
// Tag: Array
// Tag: Matrix
// Tag: Binary Search

// integers in each row are sorted from left to right
// the first integer of each row is NOT greater than the last integer of the previous row
// O(m+n) time complexity
// O(1) space complexity
public class SearchA2DMatrix2 {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int i = 0;
    int j = matrix[0].length - 1;

    // start from top right: increment row for larger values, decrement column for smaller values
    while (i < rows && j >= 0) {
      if (target == matrix[i][j]) {
        return true;
      } else if (target > matrix[i][j]) {
        i += 1;
      } else {
        j -= 1;
      }
    }

    return false;
  }
}
