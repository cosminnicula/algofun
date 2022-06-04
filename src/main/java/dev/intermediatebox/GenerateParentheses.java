package dev.intermediatebox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// [recursive]
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// n = 1 -> "()"
// n = 2 -> "(())", "()()"
// n = 3 -> "((()))", "()()()", "(())()", "()(())", "(()())"
public class GenerateParentheses {
  private final List<String> parenthesisCombinations = new ArrayList<>();

  private final Map<Character, Integer> parenthesisToNumbers = Map.of('(', 1, ')', -1);
  private final List<Character> parentheses = List.of('(', ')');

  public List<String> run(int n) {
    if (n < 0) {
      return parenthesisCombinations;
    }

    generate(n, 0, new ArrayList<>());
    return parenthesisCombinations;
  }

  private void generate(int n, int accumulatorIndex, ArrayList<Character> accumulator) {
    int sum = 0;
    for (char parenthesis : accumulator) {
      sum += parenthesisToNumbers.get(parenthesis);
    }

    if (sum < 0) { // if sum of all parentheses at any point is < 0, then current "path" will not yield a valid solution
      return;
    }

    if (accumulator.size() == n * 2) { // if the accumulator is filled with parentheses, check its total sum
      if (sum == 0) { // if sum is 0, then it's a valid combination
        parenthesisCombinations.add(accumulator.stream().map(String::valueOf).collect(Collectors.joining()));
      }
      return;
    }

    for (char parenthesis : parentheses) {
      accumulator.add(parenthesis);
      generate(n, accumulatorIndex + 1, accumulator);
      accumulator.remove(accumulatorIndex);
    }
  }
}
