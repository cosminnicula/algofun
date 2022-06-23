package dev.intermediatebox;
// Tag: String
// Tag: Sort

//Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
//
//Since the result may be very large, so you need to return a string instead of an integer.

//Input: nums = [10,2]
//Output: "210"

//Input: nums = [3,30,34,5,9]
//Output: "9534330"

import java.util.Arrays;
import java.util.Comparator;

// O(n*logn) time complexity (sort operation)
// O(n) space complexity (int to string array + largest number string)
public class LargestNumber {
  public String run(int[] nums) {
    String[] numbers = new String[nums.length];

    for (int i = 0; i < nums.length; i++) {
      numbers[i] = String.valueOf(nums[i]);
    }

    Arrays.sort(numbers, new CustomComparator());

    if (numbers[0] == "0") {
      return "0";
    }

    String largestNumber = "";
    for (String number: numbers) {
      largestNumber += number;
    }

    return largestNumber;
  }

  private class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      String order1 = s1 + s2;
      String order2 = s2 + s1;

      return order2.compareTo(order1);
    }
  }
}


