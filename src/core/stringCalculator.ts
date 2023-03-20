const checkIfTwoSeparatorsAreTogetherIn = (theOperation: string) => {
    theOperation.split('').forEach((char, index) => {
        const currentElement = char.match(/[,\n]/)
        const nextElement = theOperation[index+1]?.match(/[,\n]/);

        if (currentElement && nextElement) {
            throw new Error(`Number expected but '${theOperation[index + 1]}' found at position ${index + 1}.`);
        }
    });
}

const checkIfSeparatorIsInTheLastPositionOf = (theOperation: string) => {
    if (theOperation.at(-1)?.match(/[,\n]/)) {
        throw new Error("Number expected but EOF found.");
    }
}

const checkIfTheNumbersHaveMoreThanOneSeparator = (numbersToSum: string, separator: RegExp | string) => {
    const haveMoreThanOneSeparator = numbersToSum.split("")
        .find(char => char !== separator && isNaN(parseFloat(char)))
    if (haveMoreThanOneSeparator) {
        const differentSeparatorPos = numbersToSum.indexOf(haveMoreThanOneSeparator)
        throw new Error(`'${separator}' expected but '${haveMoreThanOneSeparator}' found at position ${differentSeparatorPos}.`)
    }
}

const extractNumbersAndSeparator = (inTheOperation: string) => {
    let separator: RegExp|string = /[,\n]/
    let operationToIterate = []
    let numbersToSum = inTheOperation

    if (inTheOperation.startsWith("//")) {
        operationToIterate = numbersToSum.split(/[\n]/)
        separator = operationToIterate[0].replace("//", "")
        numbersToSum = operationToIterate[1]
        checkIfTheNumbersHaveMoreThanOneSeparator(numbersToSum, separator);
    }

    return [numbersToSum, separator];
}

export const add = (theOperation: string) => {
    checkIfSeparatorIsInTheLastPositionOf(theOperation);
    checkIfTwoSeparatorsAreTogetherIn(theOperation);

    const [numbersToSum, separator] = extractNumbersAndSeparator(theOperation);
    const numbersToString = numbersToSum as string;

    const theOperationInThisToIterate = numbersToString.split(separator)
    const negativeNumbers = theOperationInThisToIterate.filter(number => parseFloat(number) < 0)
    if(negativeNumbers.length > 0) {
        const negativeNumbersJoined = negativeNumbers.join(",").trim()
        throw new Error(`Negative not allowed : ${negativeNumbersJoined}`)
    }

    const sum = theOperationInThisToIterate.reduce((previousNumber, currentNumber) => previousNumber + parseFloat(currentNumber), 0)

    return numbersToSum === "" ? "0" : sum.toString()
}
