package dev.intermediatebox.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
  public static void main(String[] args) {
    // first solution: m + n space complexity
    Solution1 s1 = new Solution1();

    int[][] matrix = new int[][]{
        {0, 1, 2, 0},
        {3, 4, 5, 2},
        {1, 3, 1, 5}
    };

    s1.setZeroes(matrix);

    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }

    System.out.println("---");

    // second solution: constant space complexity
    Solution2 s2 = new Solution2();

    matrix = new int[][]{
        {0, 1, 2, 0},
        {3, 4, 5, 2},
        {1, 3, 1, 5}
    };

    s2.setZeroes(matrix);

    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

  // Tag: Set
  // Tag: Matrix
  // Tag: Array

  // O(m x n) time complexity (two nested for loops)
  // O(m + n) space complexity (two sets)
  private static class Solution1 {
    public void setZeroes(int[][] matrix) {
      int rows = matrix.length;
      int columns = matrix[0].length;

      Set<Integer> zeroRows = new HashSet<>();
      Set<Integer> zeroCols = new HashSet<>();

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          if (matrix[i][j] == 0) {
            zeroRows.add(i);
            zeroCols.add(j);
          }
        }
      }

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          if (zeroRows.contains(i) || zeroCols.contains(j)) {
            matrix[i][j] = 0;
          }
        }
      }
    }
  }

  // O(m x n) time complexity (two nested for loops)
  // O(1) space complexity
  private static class Solution2 {
    public void setZeroes(int[][] matrix) {
      int rows = matrix.length;
      int columns = matrix[0].length;

      // mark the outermost  row and column + isFirstRowZero:
      // - the first row of the matrix marks the columns that need to be zeroed
      // - the extra variable + the first column of the matrix marks the rows that need to be zeroed
      boolean isFirstRowZero = false;
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          if (matrix[i][j] == 0) {
            matrix[0][j] = 0;
            if (i == 0) {
              isFirstRowZero = true;
            } else {
              matrix[i][0] = 0;
            }
          }
        }
      }

      // zero the main part of the matrix, excluding the first line and first column, which will be treated separately
      for (int i = 1; i < rows; i++) {
        for (int j = 1; j < columns; j++) {
          if (matrix[0][j] == 0 || matrix[i][0] == 0) {
            matrix[i][j] = 0;
          }
        }
      }

      // zero the first column of the matrix
      if (matrix[0][0] == 0) {
        for (int i = 0; i < rows; i++) {
          matrix[i][0] = 0;
        }
      }

      // zero the first row of the matrix
      if (isFirstRowZero) {
        for (int j = 0; j < columns; j++) {
          matrix[0][j] = 0;
        }
      }
    }
  }
}
