(() => {
  function characterReplacement(s: string, k: number): number {
    const frequencies = new Array<number>(26);
    frequencies.fill(0);
    let left = 0;

    let maxOccurrences = 0;
    let maxLength = 0;

    for (let right = 0; right < s.length; right++) {
      frequencies[s.charCodeAt(right) - 65] += 1;

      maxOccurrences = Math.max(maxOccurrences, frequencies[s.charCodeAt(right) - 65]);

      while (right - left + 1 - maxOccurrences > k) {
        frequencies[s.charCodeAt(left) - 65] -= 1;
        left += 1;
      }

      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }

  console.log(characterReplacement("ABAB", 2));
  console.log(characterReplacement("AABABBA", 1));
})();