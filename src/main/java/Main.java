import dev.intermediatebox.string.RemoveKDigits;
import dev.intermediatebox.tree.ConstructBinaryTreeFromInorderAndPostorderTraversalRecursive;
import dev.intermediatebox.tree.ConstructBinaryTreeFromPreorderAndInorderTraversalRecursive;
import dev.intermediatebox.tree.ValidateBinarySearchTree.ValidateBinarySearchTreeInorderPrecedentIterative;
import dev.intermediatebox.tree.ValidateBinarySearchTree.ValidateBinarySearchTreeInorderPrecedentRecursive;
import dev.intermediatebox.tree.ValidateBinarySearchTree.ValidateBinarySearchTreeWithIntervalIterative;
import dev.intermediatebox.tree.ValidateBinarySearchTree.ValidateBinarySearchTreeWithIntervalRecursive;
import dev.intermediatebox.tree.utils.Node;
import dev.intermediatebox.tree.utils.traversal.DFS;

import java.util.ArrayList;
import java.util.List;
// Search by both tags in any order: (?s)^(?=.*?Tag: Recursion)(?=.*?Tag: String)


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

//    ReverseWords2 r = new ReverseWords2();
//    char[] words = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//    r.run(words);
//    System.out.println(words);

//    UniqueWordAbbreviation uniqueWordAbbr = new UniqueWordAbbreviation(new String[]{"deer", "door", "cake", "card"});
//    System.out.println(uniqueWordAbbr.isUnique("dear")); // return false, dictionary word "deer" and word "dear" have the same abbreviation "d2r" but are not the same.
//    System.out.println(uniqueWordAbbr.isUnique("cart")); // return true, no words in the dictionary have the abbreviation "c2t".
//    System.out.println(uniqueWordAbbr.isUnique("cane")); // return false, dictionary word "cake" and word "cane" have the same abbreviation  "c2e" but are not the same.
//    System.out.println(uniqueWordAbbr.isUnique("make")); // return true, no words in the dictionary have the abbreviation "m2e".
//    System.out.println(uniqueWordAbbr.isUnique("cake")); // return true, because "cake" is already in the dictionary and no other word in the dictionary has "c2e" abbreviation.

//    EncodeAndDecode encodeAndDecode = new EncodeAndDecode();
//    List<String> original = Arrays.asList("Hello", "World");
//    System.out.println(original);
//    String encoded = encodeAndDecode.encode(original);
//    System.out.println(encoded);
//    List<String> decoded = encodeAndDecode.decode(encoded);
//    System.out.println(decoded);

//    GroupShiftedStrings g = new GroupShiftedStrings();
//    System.out.println(g.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));

//    RemoveDuplicateLetters r = new RemoveDuplicateLetters();
//    System.out.println(r.removeDuplicateLetters("cbacdcbc"));

//    AdditiveNumber a = new AdditiveNumber();
//    System.out.println(a.isAdditiveNumber("112358"));

//    VerifyPreorderSerializationOfABinaryTree v = new VerifyPreorderSerializationOfABinaryTree();
//    System.out.println(v.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));

//    LongestSubstringWithAtMostKDistinctCharacters l = new LongestSubstringWithAtMostKDistinctCharacters();
//    System.out.println(l.lengthOfLongestSubstringKDistinct("eceba", 2));

//    MiniParser m = new MiniParser();
//    System.out.println(m.deserialize("[123,[456,[789]]]"));

//    DecodeString d = new DecodeString();
//    System.out.println(d.decodeString("3[a2[c]]"));

//    Node root = new Node(3);
//    root.left = new Node(9);
//    root.right = new Node(20);
//    root.left.left = new Node(11);
//    root.left.right = new Node(14);
//    root.right.left = new Node(15);
//    root.right.right = new Node(19);
//
//    BinaryTreeLevelOrderTraversalRecursive br = new BinaryTreeLevelOrderTraversalRecursive();
//    var traversalR = br.levelOrder(root);
//    System.out.println(traversalR);
//
//    BinaryTreeLevelOrderTraversalIterative bi = new BinaryTreeLevelOrderTraversalIterative();
//    var traversalI = bi.levelOrder(root);
//    System.out.println(traversalI);

//    // a. recover binary search tree: sort almost sorted
//    RecoverBinarySearchTreeSort rs = new RecoverBinarySearchTreeSort();
//
//    Node root = new Node(3);
//    root.left = new Node(1);
//    root.right = new Node(4);
//    root.right.left = new Node(2);
//
//    List<Integer> traversal = new ArrayList<>();
//    DFS.inorder(root, traversal);
//    System.out.println(traversal);
//
//    rs.recoverTree(root);
//
//    traversal = new ArrayList<>();
//    DFS.inorder(root, traversal);
//    System.out.println(traversal);
//
//    // b. recover binary search tree: inorder traversal iterative
//    RecoverBinarySearchTreeInorderIterative ri = new RecoverBinarySearchTreeInorderIterative();
//
//    root = new Node(3);
//    root.left = new Node(1);
//    root.right = new Node(4);
//    root.right.left = new Node(2);
//
//    traversal = new ArrayList<>();
//    DFS.inorder(root, traversal);
//    System.out.println(traversal);
//
//    ri.recoverTree(root);
//
//    traversal = new ArrayList<>();
//    DFS.inorder(root, traversal);
//    System.out.println(traversal);
//
//    // c. recover binary search tree: inorder traversal recursive
//    RecoverBinarySearchTreeInorderRecursive rr = new RecoverBinarySearchTreeInorderRecursive();
//
//    root = new Node(3);
//    root.left = new Node(1);
//    root.right = new Node(4);
//    root.right.left = new Node(2);
//
//    traversal = new ArrayList<>();
//    DFS.inorder(root, traversal);
//    System.out.println(traversal);
//
//    rr.recoverTree(root);
//
//    traversal = new ArrayList<>();
//    DFS.inorder(root, traversal);
//    System.out.println(traversal);

//    ValidateBinarySearchTreeWithIntervalRecursive ir = new ValidateBinarySearchTreeWithIntervalRecursive();
//    Node root = new Node(10);
//    root.left = new Node(5);
//    root.right = new Node(15);
//    root.left.left = new Node(3);
//    root.left.right = new Node(7);
//    root.right.right = new Node(13);
//
//    System.out.println(ir.isValidBST(root));
//
//    ValidateBinarySearchTreeWithIntervalIterative ii = new ValidateBinarySearchTreeWithIntervalIterative();
//
//    System.out.println(ii.isValidBST(root));
//
//    ValidateBinarySearchTreeInorderPrecedentRecursive pr = new ValidateBinarySearchTreeInorderPrecedentRecursive();
//
//    System.out.println(pr.isValidBST(root));
//
//    ValidateBinarySearchTreeInorderPrecedentIterative pi = new ValidateBinarySearchTreeInorderPrecedentIterative();
//
//    System.out.println(pi.isValidBST(root));
//
//    ConstructBinaryTreeFromInorderAndPostorderTraversalRecursive c = new ConstructBinaryTreeFromInorderAndPostorderTraversalRecursive();
//
//    Node root = new Node(3);
//    root.left = new Node(9);
//    root.right = new Node(20);
//    root.right.left = new Node(15);
//    root.right.right = new Node(7);
//
//    List<Integer> traversal = new ArrayList<>();
//    DFS.inorder(root, traversal);
//    int[] inorder = traversal.stream().mapToInt(i -> i).toArray();
//
//    traversal = new ArrayList<>();
//    DFS.postorder(root, traversal);
//    int[] postorder = traversal.stream().mapToInt(i -> i).toArray();
//
//    root = c.buildTree(inorder, postorder);
//    traversal = new ArrayList<>();
//    DFS.inorder(root, traversal);
//    System.out.println(traversal);

//    ConstructBinaryTreeFromPreorderAndInorderTraversalRecursive c = new ConstructBinaryTreeFromPreorderAndInorderTraversalRecursive();
//
//    Node root = new Node(3);
//    root.left = new Node(9);
//    root.right = new Node(20);
//    root.right.left = new Node(15);
//    root.right.right = new Node(7);
//
//    List<Integer> traversal = new ArrayList<>();
//    DFS.inorder(root, traversal);
//    int[] inorder = traversal.stream().mapToInt(i -> i).toArray();
//
//    traversal = new ArrayList<>();
//    DFS.preorder(root, traversal);
//    int[] preorder = traversal.stream().mapToInt(i -> i).toArray();
//
//    root = c.buildTree(inorder, preorder);
//    traversal = new ArrayList<>();
//    DFS.inorder(root, traversal);
//    System.out.println(traversal);

    RemoveKDigits r = new RemoveKDigits();
    System.out.println(r.removeKdigits("12345264", 4));
    System.out.println(r.removeKdigits("500123", 3));
    System.out.println(r.removeKdigits("500123", 4));
  }
}
