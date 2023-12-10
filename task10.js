function validateBrackets(inputString) {
    const stack = [];
    const bracketsMap = {
        '(': ')',
        '{': '}',
        '[': ']',
    };

    for (let i = 0; i < inputString.length; i++) {
        const currentChar = inputString[i];

        if (bracketsMap[currentChar]) {
            stack.push(currentChar);
        } else if (Object.values(bracketsMap).includes(currentChar)) {
            const lastBracket = stack.pop();

            if (bracketsMap[lastBracket] !== currentChar) {
                return false;
            }
        }
    }

    return stack.length === 0;
}

console.log(validateBrackets('([{}])'));
console.log(validateBrackets('([{(}])'));