package dev.intermediatebox;

//Given a character array s, reverse the order of the words.
//
//A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
//
//Your code must solve the problem in-place, i.e. without allocating extra space.

//Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
public class ReverseWords2 {
  public void run(char[] s) {
    reverse(s, 0, s.length - 1);

    int i = 0, j = 0;
    while (j < s.length) {
      if (s[j] == ' ') {
        reverse(s, i, j - 1);
        i = j + 1;
        j = i;
      } else {
        j++;
      }
    }

    reverse(s, i, j - 1);
  }

  private void reverse(char[] s, int left, int right) {
    while (left < right) {
      char tmp = s[left];
      s[left] = s[right];
      s[right] = tmp;

      left++;
      right--;
    }
  }
}
