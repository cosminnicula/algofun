(() => {
  function isValid(s: string): boolean {
    
    const parenthesesMap: Record<string, string> = {
      '(': ')',
      '[': ']',
      '{': '}'
    };
    const stack = [];

    for (const c of s) {
      // opening parentheses are pushed to the stack
      if (parenthesesMap[c]) {
        stack.push(c);
      } else if (stack.length > 0 && parenthesesMap[stack[stack.length - 1]] === c) { // check if current parentheses is a closing one for the last parentheses in the stack
        stack.pop();
      } else {
        return false;
      }
    }

    return stack.length === 0;
  };

  console.log(isValid("()"));
  console.log(isValid("()[]{}"));
  console.log(isValid("(]"));
})();