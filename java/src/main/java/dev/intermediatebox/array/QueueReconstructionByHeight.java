package dev.intermediatebox.array;
// Tag: Array
// Tag: Sort
// Tag: Greedy

import java.util.Arrays;

// O(n^2) time complexity
// O(n) space complexity
public class QueueReconstructionByHeight {
  public int[][] reconstructQueue(int[][] people) {
    sort(people);

    int[][] solution = new int[people.length][2];
    boolean[] occupied = new boolean[people.length];

    for (int i = 0 ; i < people.length; i++) {
      // two-pointer technique: j is growing faster, while offset is growing slower
      int offset = 0;
      int j = 0;
      // at the end of this loop, j will be at first potential position at which current height (people[i][0]) can be inserted
      while (offset < people[i][1]) {
        if (occupied[j] == false || solution[j][0] == people[i][0]) {
          offset++;
        }
        j++;
      }

      // if the potential position is occupied, advance with j until a free slot is found
      while (occupied[j]) {
        j++;
      }

      solution[j][0] = people[i][0];
      solution[j][1] = people[i][1];
      occupied[j] = true;
    }

    return solution;
  }

  // sort array in ascending order, based in heights (h) and positions (k):
  // arr = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]] => sorted arr = [[4,4],[5,0],[5,2],[6,1],[7,0],[7,1]]
  private void sort(int[][] arr) {
    Arrays.sort(arr, (o1, o2) -> {
      if (o1[0] != o2[0]) {
        return o1[0] - o2[0];
      }

      return o1[1] - o2[1];
    });
  }
}
