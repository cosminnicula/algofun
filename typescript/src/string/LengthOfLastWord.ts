(() => {
  function lengthOfLastWord(s: string): number {
    let i = s.length - 1;

    while (i >= 0 && s[i] === ' ') {
      i -= 1;
    }

    let length = 0;

    while (i >= 0 && s[i] !== ' ') {
      length += 1;
      i -= 1;
    }

    return length;
  };

  console.log(lengthOfLastWord('Hello World'));
  console.log(lengthOfLastWord('   fly me   to   the moon  '));
})();