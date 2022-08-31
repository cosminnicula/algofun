(() => {
    function isPalindrome(x: number): boolean {
      if (x < 0) {
        return false;
      }

      // construct the divider
      let divider = 1;
      while (divider * 10 <= x) {
        divider = divider * 10;
      }


      while (x) {
        // last digit
        const lastDigit = x % 10;
        // first digit
        const firstDigit = Math.floor(x / divider);

        if (firstDigit !== lastDigit) {
          return false;
        }

        // get rid of the last and first digit
        x = Math.floor((x % divider) / 10);
        divider = divider / 100;
      }

      return true;
    };

  console.log(isPalindrome(121));
  console.log(isPalindrome(-121));
  console.log(isPalindrome(10));
  console.log(isPalindrome(1410110141));
})();