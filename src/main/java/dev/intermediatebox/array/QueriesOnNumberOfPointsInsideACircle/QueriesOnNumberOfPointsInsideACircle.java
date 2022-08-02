package dev.intermediatebox.array.QueriesOnNumberOfPointsInsideACircle;
// Tag: Array

import dev.intermediatebox.array.utils.Geometry;

// O(n*m) time complexity (n is number of points, m is number of queries)
// O(1) space complexity
public class QueriesOnNumberOfPointsInsideACircle {
  public int[] countPoints(int[][] points, int[][] queries) {
    int solution[] = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int count = 0;
      for (int j = 0; j < points.length; j++) {
         if (Geometry.euclidianDistance(points[j][0], queries[i][0], points[j][1], queries[i][1]) <= Math.pow(queries[i][2], 2)) {
            count++;
         }
      }

      solution[i] = count;
    }

    return solution;
  }
}
