package dev.intermediatebox.concepts.recursion;

public class CapitalizeSentence {
  public static void main(String[] args) {
    CapitalizeSentence capitalizeSentence = new CapitalizeSentence();
    var solution = capitalizeSentence.recursion("abc def hjg");
    System.out.println(solution);
  }

  private String recursion(String string) {
    if (string.isEmpty()) {
      return string;
    }

    String word = "";
    if (string.indexOf(' ') >= 0) {
      word = string.substring(0, string.indexOf(' '));
    } else {
      word = string;
    }
    word = word.substring(0, 1).toUpperCase() + word.substring(1);

    if (string.indexOf(' ') >= 0) {
      return word + ' ' + recursion(string.substring(string.indexOf(' ')  + 1));
    } else { // else is for clarity; can be omitted
      return word + recursion("");
    }
  }
}
