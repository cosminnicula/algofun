// Search by both tags in any order: (?s)^(?=.*?Tag: Recursion)(?=.*?Tag: String)


import dev.intermediatebox.array.utils.sort.MergeSort;

import java.util.Arrays;

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
//    DFSRecursive.inorder(root, traversal);
//    System.out.println(traversal);
//
//    rs.recoverTree(root);
//
//    traversal = new ArrayList<>();
//    DFSRecursive.inorder(root, traversal);
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
//    DFSRecursive.inorder(root, traversal);
//    System.out.println(traversal);
//
//    ri.recoverTree(root);
//
//    traversal = new ArrayList<>();
//    DFSRecursive.inorder(root, traversal);
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
//    DFSRecursive.inorder(root, traversal);
//    System.out.println(traversal);
//
//    rr.recoverTree(root);
//
//    traversal = new ArrayList<>();
//    DFSRecursive.inorder(root, traversal);
//    System.out.println(traversal);
//
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
//    DFSRecursive.inorder(root, traversal);
//    int[] inorder = traversal.stream().mapToInt(i -> i).toArray();
//
//    traversal = new ArrayList<>();
//    DFSRecursive.postorder(root, traversal);
//    int[] postorder = traversal.stream().mapToInt(i -> i).toArray();
//
//    root = c.buildTree(inorder, postorder);
//    traversal = new ArrayList<>();
//    DFSRecursive.inorder(root, traversal);
//    System.out.println(traversal);
//
//    ConstructBinaryTreeFromPreorderAndInorderTraversalRecursive c = new ConstructBinaryTreeFromPreorderAndInorderTraversalRecursive();
//
//    Node root = new Node(3);
//    root.left = new Node(9);
//    root.right = new Node(20);
//    root.right.left = new Node(15);
//    root.right.right = new Node(7);
//
//    List<Integer> traversal = new ArrayList<>();
//    DFSRecursive.inorder(root, traversal);
//    int[] inorder = traversal.stream().mapToInt(i -> i).toArray();
//
//    traversal = new ArrayList<>();
//    DFSRecursive.preorder(root, traversal);
//    int[] preorder = traversal.stream().mapToInt(i -> i).toArray();
//
//    root = c.buildTree(inorder, preorder);
//    traversal = new ArrayList<>();
//    DFSRecursive.inorder(root, traversal);
//    System.out.println(traversal);
//
//    RemoveKDigits r = new RemoveKDigits();
//    System.out.println(r.removeKdigits("12345264", 4));
//    System.out.println(r.removeKdigits("500123", 3));
//    System.out.println(r.removeKdigits("500123", 4));

//    // DSF traversal
//    // Inorder
//    Node root = new Node(4);
//    root.left = new Node(2);
//    root.right = new Node(5);
//    root.left.left = new Node(1);
//    root.left.right = new Node(3);
//
//    List<Integer> traversal = new ArrayList<>();
//    DFSRecursive.inorder(root, traversal);
//    System.out.println(traversal);
//
//    traversal = new ArrayList<>();
//    DFSIterative.inorder(root, traversal);
//    System.out.println(traversal);
//
//    // Preorder
//    root = new Node(1);
//    root.left = new Node(2);
//    root.right = new Node(5);
//    root.left.left = new Node(3);
//    root.left.right = new Node(4);
//
//    traversal = new ArrayList<>();
//    DFSRecursive.preorder(root, traversal);
//    System.out.println(traversal);
//
//    traversal = new ArrayList<>();
//    DFSIterative.preorder(root, traversal);
//    System.out.println(traversal);
//
//    // Postorder
//    root = new Node(5);
//    root.left = new Node(3);
//    root.right = new Node(4);
//    root.left.left = new Node(1);
//    root.left.right = new Node(2);
//
//    traversal = new ArrayList<>();
//    DFSRecursive.postorder(root, traversal);
//    System.out.println(traversal);
//
//    traversal = new ArrayList<>();
//    DFSIterative.postorder(root, traversal);
//    System.out.println(traversal);
//
//    // BFS traversal
//    // Iterative
//    root = new Node(1);
//    root.left = new Node(2);
//    root.right = new Node(3);
//    root.left.left = new Node(4);
//    root.left.right = new Node(5);
//
//    traversal = new ArrayList<>();
//    BFSIterative.traverse(root, traversal);
//    System.out.println(traversal);

//    BinaryTreeRightSideViewBFS rb = new BinaryTreeRightSideViewBFS();
//
//    Node root = new Node(1);
//    root.left = new Node(2);
//    root.right = new Node(3);
//    root.left.right = new Node(5);
//    root.right.right = new Node(4);
//
//    System.out.println(rb.rightSideView(root));
//
//    BinaryTreeRightSideViewRecursiveDFS rd = new BinaryTreeRightSideViewRecursiveDFS();
//
//    System.out.println(rd.rightSideView(root));

//    DeepestLeavesSumBFS db = new DeepestLeavesSumBFS();
//
//    Node root = new Node(1);
//    root.left = new Node(2);
//    root.right = new Node(3);
//    root.left.left = new Node(4);
//    root.left.right = new Node(5);
//    root.right.right = new Node(6);
//    root.left.left.left = new Node(7);
//    root.right.right.right = new Node(8);
//
//    System.out.println(db.deepestLeavesSum(root));
//
//    DeepestLeavesSumDFS dd = new DeepestLeavesSumDFS();
//
//    System.out.println(dd.deepestLeavesSum(root));

//    BinaryTreeZigZagLevelOrderTraversal bz = new BinaryTreeZigZagLevelOrderTraversal();
//
//    TreeNode root = new TreeNode(3);
//    root.left = new TreeNode(9);
//    root.right = new TreeNode(20);
//    root.right.left = new TreeNode(15);
//    root.right.right = new TreeNode(7);
//
//    System.out.println(bz.zigzagLevelOrder(root));

//    ConvertSortedArrayToBinarySearchTree ca = new ConvertSortedArrayToBinarySearchTree();
//
//    int[] array = new int[] { -10, -3, 0, 5, 9 };
//
//    TreeNode root = ca.sortedArrayToBST(array);
//
//    List<Integer> traversal = new LinkedList<>();
//
//    DFSRecursive.inorder(root, traversal);
//
//    System.out.println(traversal);

//    ConvertSortedListToBinarySearchTree cl = new ConvertSortedListToBinarySearchTree();
//
//    ListNode head = new ListNode(-10);
//    head.next = new ListNode(-3);
//    head.next.next = new ListNode(0);
//    head.next.next.next = new ListNode(5);
//    head.next.next.next.next = new ListNode(9);
//
//    TreeNode root = cl.sortedListToBST(head);
//
//    List<Integer> traversal = new LinkedList<>();
//
//    DFSRecursive.inorder(root, traversal);
//
//    System.out.println(traversal);

//    FlattenBinaryTreeToLinkedListRecursive fr = new FlattenBinaryTreeToLinkedListRecursive();
//
//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(5);
//    root.left.left = new TreeNode(3);
//    root.left.right = new TreeNode(4);
//    root.right.right = new TreeNode(6);
//
//    List<Integer> traversal = new LinkedList<>();
//    DFSRecursive.preorder(root, traversal);
//    System.out.println(traversal);
//
//    fr.flatten(root);
//
//    while (root != null ) {
//      System.out.println(root.value);
//      root = root.right;
//    }
//
//    FlattenBinaryTreeToLinkedListIterative fi = new FlattenBinaryTreeToLinkedListIterative();
//
//    root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(5);
//    root.left.left = new TreeNode(3);
//    root.left.right = new TreeNode(4);
//    root.right.right = new TreeNode(6);
//
//    traversal = new LinkedList<>();
//    DFSRecursive.preorder(root, traversal);
//    System.out.println(traversal);
//
//    fi.flatten(root);
//
//    while (root != null ) {
//      System.out.println(root.value);
//      root = root.right;
//    }
//
//    PopulateNextRightPointersInEachNode p = new PopulateNextRightPointersInEachNode();
//
//    TreeNodeWithLink root = new TreeNodeWithLink(1);
//    root.left = new TreeNodeWithLink(2);
//    root.right = new TreeNodeWithLink(3);
//    root.left.left = new TreeNodeWithLink(4);
//    root.left.right = new TreeNodeWithLink(5);
//    root.right.left = new TreeNodeWithLink(6);
//    root.right.right = new TreeNodeWithLink(7);
//
//    p.connect(root);
//
//    List<Integer> traversal = new LinkedList<>();
//    LevelIterative.traverse(root, traversal);
//    System.out.println(traversal);

//    SumRootToLeafNumbers s = new SumRootToLeafNumbers();
//
//    TreeNode root = new TreeNode(4);
//    root.left = new TreeNode(9);
//    root.right = new TreeNode(0);
//    root.left.left = new TreeNode(5);
//    root.left.right = new TreeNode(1);
//
//    System.out.println(s.sumNumbers(root));

//    TreeNode root = new TreeNode(7);
//    root.left = new TreeNode(3);
//    root.right = new TreeNode(15);
//    root.right.left = new TreeNode(9);
//    root.right.right = new TreeNode(20);
//
//    BinarySearchTreeIterator1 b1 = new BinarySearchTreeIterator1(root);
//
//    while (b1.hasNext()) {
//      System.out.println(b1.next());
//    }
//
//    BinarySearchTreeIterator2 b2 = new BinarySearchTreeIterator2(root);
//
//    while (b2.hasNext()) {
//      System.out.println(b2.next());
//    }

//    CountCompleteTreeNodes c = new CountCompleteTreeNodes();
//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(3);
//    root.left.left = new TreeNode(4);
//    root.left.right = new TreeNode(5);
//    root.right.left = new TreeNode(6);
//
//    System.out.println(c.countNodes(root));

//    KthSmallestElementInBSTRecursive kr = new KthSmallestElementInBSTRecursive();
//
//    TreeNode root = new TreeNode(5);
//    root.left = new TreeNode(3);
//    root.right = new TreeNode(6);
//    root.left.left = new TreeNode(2);
//    root.left.right = new TreeNode(4);
//    root.left.left.left = new TreeNode(1);
//
//    System.out.println(kr.kthSmallest(root, 4));
//
//    KthSmallestElementInBSTIterative ki = new KthSmallestElementInBSTIterative();
//
//    System.out.println(ki.kthSmallest(root, 4));

//    SearchA2DMatrix1 s1 = new SearchA2DMatrix1();
//    int[][] matrix = new int[][] {
//        { 1, 4, 7, 11, 15 },
//        { 2, 5, 8, 12, 19 },
//        { 3, 6, 9, 16, 22 },
//        { 10, 13, 14, 17, 24 },
//        { 18, 21, 23, 26, 30 },
//    };
//
//    System.out.println(s1.searchMatrix(matrix, 5));
//
//    SearchA2DMatrix2 s2 = new SearchA2DMatrix2();
//
//    System.out.println(s2.searchMatrix(matrix, 5));

//    int[][] matrix = new int[][]{
//        {3, 0, 1, 4, 2},
//        {5, 6, 3, 2, 1},
//        {1, 2, 0, 1, 5},
//        {4, 1, 0, 1, 7},
//        {1, 0, 3, 0, 5},
//    };
//
//    RangeSumQuery2DImmutable r = new RangeSumQuery2DImmutable(matrix);
//
//    System.out.println(r.sumRegion(2, 1, 4, 3));
//    System.out.println(r.sumRegion(1, 1, 2, 2));
//    System.out.println(r.sumRegion(0, 0, 0, 0));

//    CountNumberOfTicTacToeGames c = new CountNumberOfTicTacToeGames();
//
//    int[][] board = new int[][]{
//        {-1, -1, -1},
//        {-1, -1, -1},
//        {-1, -1, -1},
//    };
//
//    int total = c.computeTotal(board, 0, 0);
//
//    System.out.println("total number of tic tac toe games (including wins and draws): " + total);

//    QueueReconstructionByHeight q = new QueueReconstructionByHeight();
//
//    int[][] people = new int[][]{
//        {7, 0},
//        {4, 4},
//        {7, 1},
//        {5, 0},
//        {6, 1},
//        {5, 2},
//    };
//
//    var solution = q.reconstructQueue(people);
//    for (int[] element: solution) {
//      System.out.println(element[0] + "," + element[1]);
//    }

//    CircularQueue c = new CircularQueue(3);
//    System.out.println(c.enQueue(1)); // return True
//    System.out.println(c.enQueue(2)); // return True
//    System.out.println(c.enQueue(3)); // return True
//    System.out.println(c.enQueue(4)); // return False
//    System.out.println(c.Rear());     // return 3
//    System.out.println(c.isFull());   // return True
//    System.out.println(c.deQueue());  // return True
//    System.out.println(c.enQueue(4)); // return True
//    System.out.println(c.Rear());     // return 4

//    SumOfEvenNumbersAfterQueries s = new SumOfEvenNumbersAfterQueries();
//
//    int[] nums = new int[]{1, 2, 3, 4};
//    int[][] queries = new int[][]{
//        {1, 0},
//        {-3, 1},
//        {-4, 0},
//        {2, 3}
//    };
//
//    System.out.println(Arrays.toString(s.sumEvenAfterQueries(nums, queries)));

//    QueensThatCanAttackTheKing q = new QueensThatCanAttackTheKing();
//    int[][] queens = new int[][]{
//        {5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}
//    };
//    int[] king = new int[]{3, 4};
//    System.out.println(q.queensAttacktheKing(queens, king));

//    QueriesOnNumberOfPointsInsideACircle q = new QueriesOnNumberOfPointsInsideACircle();
//    int[][] points = new int[][]{
//        {1, 3}, {3, 3}, {5, 3}, {2, 2}
//    };
//    int[][] queries = new int[][]{
//        {2, 3, 1}, {4, 3, 1}, {1, 1, 2}
//    };
//    System.out.println(Arrays.toString(q.countPoints(points, queries)));


//    int[] array = new int[]{1, 5, 8, 9, 15};
//    System.out.println(Search.binarySearchIterative(array, 15));
//    System.out.println(Search.binarySearchIterative(array, 99));
//    System.out.println(Search.binarySearchRecursive(array, 15));
//    System.out.println(Search.binarySearchRecursive(array, 99));

//    WordSubsets w = new WordSubsets();
//    String[] A = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
//    String[] B = new String[]{"e", "o"};
//    System.out.println(w.wordSubsets(A, B));
//    A = new String[]{"warrior", "world"};
//    B = new String[]{"wrr"};
//    System.out.println(w.wordSubsets(A, B));

    int[] array = new int[]{3, 5, 1, 2, 8, 4, 9};
    MergeSort.sort(array);
    System.out.println(Arrays.toString(array));
  }
}
