package dev.intermediatebox.string;

// Tag: String
// Tag: HashTable

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

// I can be placed before V (5) and X (10) to make 4 and 9.
// X can be placed before L (50) and C (100) to make 40 and 90.
// C can be placed before D (500) and M (1000) to make 400 and 900.
// corresponds to:
// 4 -> IV; 9 -> IX
// 40 -> XL; 90 -> XC
// 400 -> CD; 900 -> CM

// 800 -> DCCC
// 1400 -> MCD
// 1993 -> MCMXCIII
// 3999 -> MMMCMXCIX

// O(1) time complexity because there is a finite number of symbols; O(1) space complexity
public class IntegerToRoman {
  public String run(int num) {
    int[] values = {          1000, 900, 500, 400, 100,   90,   50, 40,  10,    9,    5,   4,   1};
    String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    String roman = "";

    // greedy
    for (int i = 0; i < values.length; i++) {
      while (num - values[i] >= 0) {
        num = num - values[i];
        roman += romanSymbols[i];
      }
    }

    return roman;
  }
}
