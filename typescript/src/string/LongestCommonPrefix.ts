(() => {
  function longestCommonPrefix(strs: string[]): string {
    let prefix = "";

    // iterate all characters in the first string
    for (let i = 0; i < strs[0].length; i++) {
      // iterate all strings in the array
      for (let s of strs) {
        if (i == s.length || s[i] !== strs[0][i]) {
          return prefix;
        }
      }

      prefix = prefix + strs[0][i];
    }

    return prefix;
  };

  console.log(longestCommonPrefix(["flower","flow","flight"]));
  console.log(longestCommonPrefix(["dog","racecar","car"]));
})();