package dev.intermediatebox.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 1, 1, 2, 2, 3};
    int k1 = 2;
    int[] nums2 = new int[]{-1, -1};
    int k2 = 1;

    Solution1 s1 = new Solution1();
    System.out.println(Arrays.toString(s1.topKFrequent(nums1, k1)));
    System.out.println(Arrays.toString(s1.topKFrequent(nums2, k2)));

    Solution2 s2 = new Solution2();
    System.out.println(Arrays.toString(s2.topKFrequent(nums1, k1)));
    System.out.println(Arrays.toString(s2.topKFrequent(nums2, k2)));
  }

  // Tag: HashTable
  // Tag: Heap (PriorityQueue)
  // Tag: Sort

  // O(nlog(n)) time complexity
  // O(n) space complexity
  private static class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> frequency = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
        frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
      }

      // sort, in descending order, the frequency map by count, and store the corresponding nums to an array
      Integer[] sortedIndexes = frequency.entrySet().stream()
          .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
          .limit(k)
          .map(e -> e.getKey())
          .toArray(Integer[]::new);

      // get top K nums associated with the indexes
      int[] result = new int[k];
      for (int i = 0; i < k; i++) {
        result[i] = sortedIndexes[i];
      }

      return result;
    }
  }

  // O(klog(n)) time complexity
  // O(n) space complexity
  private static class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> frequency = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
        frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
      }

      PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> frequency.get(n1) - frequency.get(n2));

      // iterate over the nums of the Map and add them in the max heap. the comparator will compare the count associated with each num.
      for (Integer num : frequency.keySet()) {
        maxHeap.add(num);

        if (maxHeap.size() > k) {
          maxHeap.poll();
        }
      }

      int[] result = new int[k];
      for (int i = 0; i < k; i++) {
        result[i] = maxHeap.poll();
      }

      return result;
    }
  }
}
