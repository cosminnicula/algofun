(() => {
  function plusOne(digits: number[]): number[] {
    let carry = 1;
    for (let i = digits.length - 1; i >= 0; i--) {
      let sum = digits[i] + carry;
      carry = sum >= 10 ? 1 : 0;
      digits[i] = sum % 10;
    }

    if (carry === 1) {
      digits.unshift(1);
    }

    return digits;
  };

  console.log(plusOne([9, 9, 9]));
  console.log(plusOne([1, 2, 3]));
})();