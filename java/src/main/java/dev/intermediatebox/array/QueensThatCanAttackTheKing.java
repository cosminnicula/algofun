package dev.intermediatebox.array;
// Tag: Array
// Tag: Matrix

import java.util.LinkedList;
import java.util.List;


// O(1) time complexity
// O(1) space complexity
public class QueensThatCanAttackTheKing {

  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    List<List<Integer>> solution = new LinkedList<>();

    boolean[][] queensTable = new boolean[8][8];

    for (int[] queen: queens) {
      queensTable[queen[0]][queen[1]] = true;
    }

    // directionX and directionY gives the moving direction (8 in total, since [0,0] is excluded)
    int[] directionX = new int[] { -1, 0, 1};
    int[] directionY = new int[]{ -1, 0, 1};
    for (int dx : directionX) {
      for (int dy : directionY) {
        if (dx == 0 && dy == 0) {
          continue;
        }

        int x = king[0];
        int y = king[1];

        int step = 0;
        while (x + dx >=0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
          x += dx;
          y += dy;

          if (queensTable[x][y]) {
            solution.add(List.of(x, y));
            break;
          }
        }
      }
    }

    return solution;
  }
}
