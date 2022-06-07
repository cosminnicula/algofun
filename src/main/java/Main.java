import dev.intermediatebox.*;

public class Main {
  public static void main(String[] args) {
//    AddTwoNumbers1 atn = new AddTwoNumbers1();
//
//    List<Integer> list1 = List.of(3, 5, 7);
//    List<Integer> list2 = List.of(8, 7);
//
//    System.out.println(atn.run(list1, list2));

//    LongestSubstringWithoutRepeatingCharacters2 l = new LongestSubstringWithoutRepeatingCharacters2();
//    System.out.println(l.run("pwwkew"));

//    LongestPalindromicSubstring l = new LongestPalindromicSubstring();
//    System.out.println(l.run("abcbd"));

//      Atoi atoi = new Atoi();
//      System.out.println(atoi.run("-999999999999"));

//    IntegerToRoman itr = new IntegerToRoman();
//    System.out.println(itr.run(800));

//    LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
//    System.out.println(l.run("23"));

////    BinaryTreeDepthFirstTraversal btdft = new BinaryTreeDepthFirstTraversal();
//    BinaryTreeBreadthFirstTraversal btbft = new BinaryTreeBreadthFirstTraversal();
//    Node head = new Node(1);
//    head.left = new Node(2);
//    head.left.left = new Node(3);
//    head.left.right = new Node(4);
//    head.right = new Node(5);
//    head.right.left = new Node(6);
//
////    System.out.println(btdft.run(head));
//    System.out.println(btbft.run(head));

//    GenerateParentheses gp = new GenerateParentheses();
//    System.out.println(gp.run(3));

//    GroupAnagrams2 ga = new GroupAnagrams2();
//    System.out.println(ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

//    MultiplyStrings ms = new MultiplyStrings();
//    System.out.println(ms.run("213", "356"));

//    SimplifyPath sp = new SimplifyPath();
//    System.out.println(sp.run("/some/../path/to/./folder/."));

//    WaysToDecode wd = new WaysToDecode();
//    System.out.println(wd.run("221020"));

//    PalindromePartitioning p = new PalindromePartitioning();
//    System.out.println(p.run("aab"));

//    WordBreak w = new WordBreak();
//    System.out.println(w.run("catsandog", List.of("cats", "dog", "sand", "and", "cat")));

//    ReverseWords r = new ReverseWords();
//    System.out.println(r.run("  a good   example  "));

//    LongestSubstringWithAtMostTwoDistinctCharacters l = new LongestSubstringWithAtMostTwoDistinctCharacters();
//    System.out.println(l.run("caaaaaaaabdeeeeeeeeefa"));

//    OneEditDistance o = new OneEditDistance();
//    System.out.println(o.run("ab", "ab"));

//    LargestNumber l = new LargestNumber();
//    System.out.println(l.run(new int[]{3, 30, 34, 5, 9}));

//    TriePrefixTree t = new TriePrefixTree();
//    t.insert("apple");
//    t.insert("apples");
//    System.out.println(t.search("apple"));
//    System.out.println(t.startsWith("app"));
//    System.out.println(t.search("app"));
//    System.out.println(t.search("apples"));

//    WordDictionary t = new WordDictionary();
//    t.addWord("apple");
//    t.addWord("apples");
//    System.out.println(t.search("apple"));
//    System.out.println(t.search("app."));
//    System.out.println(t.search("app.."));
//    System.out.println(t.search("apples"));

//    BasicCalculator2 b = new BasicCalculator2();
//    System.out.println(b.run("3+5 / 2 "));
//    System.out.println(b.run("3+ 1+2 *2  "));

//    ShortestWordDistance2 s = new ShortestWordDistance2(new String[] {"practice", "makes", "perfect", "coding", "makes"});
//    System.out.println(s.shortest("makes", "coding"));

    ReverseWords2 r = new ReverseWords2();
    char[] words = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
    r.run(words);
    System.out.println(words);
  }
}
