(() => {
  function longestSubstring(s: string, k: number): number {
    let maxLength = 0;

    for (let i = 0; i < s.length; i++) {
      const frequencies = new Array<number>(26);
      frequencies.fill(0);
      
      for (let j = i; j < s.length; j++) {
        frequencies[s.charCodeAt(j) - 97] += 1;

        if (hasKRepeatingCharacters(frequencies, k)) {
          maxLength = Math.max(maxLength, j - i + 1);
        }
      }
    }

    return maxLength;
  }

  function hasKRepeatingCharacters(frequencies: Array<number>, k: number): boolean {
    let charactersCount = 0;
    let kRepeatingCharactersCount = 0;

    for (let frequency of frequencies) {
      if (frequency > 0) {
        charactersCount += 1;
      }

      if (frequency >= k) {
        kRepeatingCharactersCount += 1;
      }
    }

    return charactersCount === kRepeatingCharactersCount;
  }

  console.log(longestSubstring("aaabb", 3));
  console.log(longestSubstring("ababbc", 2));
})();