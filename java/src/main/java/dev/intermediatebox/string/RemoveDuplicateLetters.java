package dev.intermediatebox.string;
// Tag: String
// Tag: Stack
// Tag: Greedy

//Given a string s, remove duplicate letters so that every letter appears once and only once.
//You must make sure your result is the smallest in lexicographical order among all possible results.

import java.util.*;

// Input: s = "cbacdcbc" -> Output: "acdb"

// O(n) time complexity
// O(1) space complexity (unique characters < 26)
public class RemoveDuplicateLetters {
  public String removeDuplicateLetters(String s) {
    Set<Character> uniqueChars = new HashSet<>();
    Stack<Character> stack = new Stack<>();
    Map<Character, Integer> occurrences = new HashMap<>();

    // stores the character occurrences
    for (char c: s.toCharArray()) {
      if (!occurrences.containsKey(c)) {
        occurrences.put(c, 0);
      }

      occurrences.put(c, occurrences.get(c) + 1);
    }

    for (char currentCharacter: s.toCharArray()) {
      // character was not seen before
      if (!uniqueChars.contains(currentCharacter)) {
        // a character can be removed from the stack (and from the set) if:
        // 1. currentCharacter < stack character
        // 2. it appears again in the string
        while (!stack.isEmpty() && currentCharacter < stack.peek() && occurrences.get(stack.peek()) > 1) {
          char removedCharacter = stack.peek();
          stack.pop();
          uniqueChars.remove(removedCharacter);
          occurrences.put(removedCharacter, occurrences.get(removedCharacter) - 1);
        }

        // adds the character to the stack and to the set
        stack.push(currentCharacter);
        uniqueChars.add(currentCharacter);
      }
    }

    String result = "";
    for (Character c : stack) {
      result += c.charValue();
    }
    return  result;
  }
}
