package dev.intermediatebox.array;
// Tag: Array
// Tag: Matrix
// Tag: Prefix sum

// O(m*n) time complexity (constructor)
// O(1) time complexity (query)
// O(m*n) space complexity

public class RangeSumQuery2DImmutable {

  int[][] computedMatrix;

  public RangeSumQuery2DImmutable(int[][] matrix) {
    if (matrix.length == 0) {
      return;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
      }
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
      }
    }

    this.computedMatrix = matrix;
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    // sum((row1,col1), (row2, col2)) =  (row2, col2) - [(row2, col1 - 1) + (row1 - 1, col2) - (row1 - 1, col1 - 1)]
    int totalWithExtra = computedMatrix[row2][col2];
    // if col1 or row1 is 0, then there is no extra region
    int extra = (col1 != 0 ? computedMatrix[row2][col1 - 1] : 0) + (row1 != 0 ? computedMatrix[row1 - 1][col2] : 0) - ((row1 != 0 && col1 != 0) ? computedMatrix[row1 - 1][col1 - 1] : 0);

    return totalWithExtra - extra;
  }
}
