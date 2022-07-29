package dev.intermediatebox.concepts.recursion;

public class Palindrome {
  public static void main(String[] args) {
    Palindrome palindrome = new Palindrome();
    var solution = palindrome.recursion("acbbca");
    System.out.println(solution);
  }

  private boolean recursion(String palindrome) {
    if (palindrome.length() == 0 || palindrome.length() == 1) {
      return true;
    }

    if(palindrome.charAt(0) != palindrome.charAt(palindrome.length() - 1)) {
      return false;
    }

    return recursion(palindrome.substring(1, palindrome.length() - 1));
  }
}
