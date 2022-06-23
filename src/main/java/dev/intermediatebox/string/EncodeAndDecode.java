package dev.intermediatebox.string;
// Tag: String

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
//
//Machine 1 (sender) has the function:
//
//string encode(vector<string> strs) {
//// ... your code
//return encoded_string;
//}
//
//Machine 2 (receiver) has the function:
//
//vector<string> decode(string s) {
////... your code
//return strs;
//}
//
//So Machine 1 does:
//
//string encoded_string = encode(strs);
//
//and Machine 2 does:
//
//vector<string> strs2 = decode(encoded_string);
//
//strs2 in Machine 2 should be the same as strs in Machine 1.
//
//Implement the encode and decode methods.
//
//You are not allowed to solve the problem using any serialize methods (such as eval).

// O(n) time complexity
// O(1) space complexity
public class EncodeAndDecode {
  public String encode(List<String> strs) {
    // empty string
    if (strs.size() == 0) {
      return Character.toString((char)258);
    }

    // concatenate strings with a delimiter that is outside the standard 256 ASCII character set
    String delimiter = Character.toString((char)257);
    String encoded = "";
    for(String s: strs) {
      encoded += s;
      encoded += delimiter;
    }

    encoded = encoded.substring(0, encoded.length() - 1);

    return encoded;
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    if (s.equals(Character.toString((char)258))) {
      return new ArrayList();
    }

    String delimiter = Character.toString((char)257);

    return Arrays.asList(s.split(delimiter));
  }
}
