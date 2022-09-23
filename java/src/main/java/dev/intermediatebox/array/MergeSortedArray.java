package dev.intermediatebox.array;
// Tag: Array
// Tag: TwoPointers
// Tag: Sort

import java.util.Arrays;

public class MergeSortedArray {
  public static void main(String[] args) {
    Solution s = new Solution();

    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[]{2, 5, 6};
    s.merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));

    nums1 = new int[]{2, 2, 3, 0, 0, 0};
    nums2 = new int[]{1, 5, 6};
    s.merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));

    nums1 = new int[]{1};
    nums2 = new int[]{};
    s.merge(nums1, 1, nums2, 0);
    System.out.println(Arrays.toString(nums1));

    nums1 = new int[]{0};
    nums2 = new int[]{1};
    s.merge(nums1, 0, nums2, 1);
    System.out.println(Arrays.toString(nums1));
  }

  private static class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = m - 1;
      int j = n - 1;
      int k = m + n - 1;

      while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
          nums1[k] = nums1[i];
          i -= 1;
        } else {
          nums1[k] = nums2[j];
          j -= 1;
        }

        k -= 1;
      }

      // if j, which is iterating nums2, reaches the end first, then there's nothing left to do
      // if i, which is iterating nums1, reaches the end first, then all the remaining elements in num2 needs to be iterated
      while (j >= 0) {
        nums1[k] = nums2[j];
        k -= 1;
        j -= 1;
      }
    }
  }
}
