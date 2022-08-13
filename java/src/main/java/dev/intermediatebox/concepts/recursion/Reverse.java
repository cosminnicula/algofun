package dev.intermediatebox.concepts.recursion;

public class Reverse {
  public static void main(String[] args) {
    Reverse reverse = new Reverse();
    var solution = reverse.recursion("abc");
    System.out.println(solution);
  }

  private String recursion(String string) {
    if(string.isEmpty()) {
      return string;
    }

    return recursion(string.substring(1)) + string.charAt(0);
  }
}
