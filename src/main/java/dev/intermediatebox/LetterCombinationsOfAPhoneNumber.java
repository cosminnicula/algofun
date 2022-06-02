package dev.intermediatebox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
// 2: abc, 3: def, 4: ghi, 5: jkl; 6: mno; 7: pqrs; 8: tuv, 9: wxyz, 0: [space]

// 23 -> 'ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf'

// O(4^n) time complexity, where N is number of digits, and 4 is the maximum number of letters per digit (e.g. 7 has 4 letters)
// O(n) space complexity, where n is the space occupied by the recursion call stack
public class LetterCombinationsOfAPhoneNumber {
  private List<String> letterCombinations = new ArrayList<>();

  private Map<Character, List<Character>> digitsToLetters = Map.of(
      '0', List.of(' '),
      '2', List.of('a', 'b', 'c'),
      '3', List.of('d', 'e', 'f'),
      '4', List.of('g', 'h', 'i'),
      '5', List.of('j', 'k', 'l'),
      '6', List.of('m', 'n', 'o'),
      '7', List.of('p', 'q', 'r', 's'),
      '8', List.of('t', 'u', 'v'),
      '9', List.of('w', 'x', 'y', 'z')
  );

  private String digits;

  public List<String> run(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }

    this.digits = digits;

    generateCombinations(0, new ArrayList<>());

    return letterCombinations;
  }

  private void generateCombinations(int i, ArrayList<Character> accumulator) {
    if (i == digits.length()) {
      letterCombinations.add(accumulator.stream().map(String::valueOf).collect(Collectors.joining()));
      // backtrack
      return;
    }

    List<Character> digitLetters = digitsToLetters.get(digits.charAt(i));
    for (Character letter: digitLetters) {
      accumulator.add(letter);
      // move to next digit
      generateCombinations(i + 1, accumulator);
      accumulator.remove(i);
    }
  }
}
