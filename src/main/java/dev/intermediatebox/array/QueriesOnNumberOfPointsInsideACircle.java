package dev.intermediatebox.array;
// Tag: Array

// O(n*m) time complexity (n is number of points, m is number of queries)
// O(1) space complexity
public class QueriesOnNumberOfPointsInsideACircle {
  public int[] countPoints(int[][] points, int[][] queries) {
    int solution[] = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int count = 0;
      for (int j = 0; j < points.length; j++) {
         if (Math.pow(points[j][0] - queries[i][0], 2) + Math.pow(points[j][1] - queries[i][1], 2) <= Math.pow(queries[i][2], 2)) {
            count++;
         }
      }

      solution[i] = count;
    }

    return solution;
  }
}
