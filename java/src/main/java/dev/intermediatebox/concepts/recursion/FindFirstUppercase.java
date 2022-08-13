package dev.intermediatebox.concepts.recursion;

public class FindFirstUppercase {
  public static void main(String[] args) {
    FindFirstUppercase findFirstUppercase = new FindFirstUppercase();
    var solution = findFirstUppercase.recursion("abcDef");
    System.out.println(solution);
  }

  private char recursion(String string) {

    if (string.isEmpty()) {
      return ' ';
    }

    if (Character.isUpperCase(string.charAt(0))) {
      return string.charAt(0);
    }

    return recursion(string.substring(1));
  }
}
