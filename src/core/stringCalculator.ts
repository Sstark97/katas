const checkIfTwoSeparatorsAreTogetherIn = (theOperation: string) => {
    let error = ""
    theOperation.split('').forEach((char, index) => {
        const currentElement = char.match(/[,\n]/)
        const nextElement = theOperation[index+1]?.match(/[,\n]/);

        if (currentElement && nextElement) {
            error += `Number expected but '${theOperation[index + 1]}' found at position ${index + 1}.\n`;
        }
    });

    return error
}

const checkIfSeparatorIsInTheLastPositionOf = (theOperation: string) => {
    let error = ""
    if (theOperation.at(-1)?.match(/[,\n]/)) {
        error += "Number expected but EOF found.\n";
    }

    return error
}

const checkIfTheNumbersHaveMoreThanOneSeparator = (numbersToSum: string, separator: RegExp | string) => {
    const haveMoreThanOneSeparator = numbersToSum.split("")
        .find(char => char !== separator && isNaN(parseFloat(char)))
    let error = ""
    if (haveMoreThanOneSeparator) {
        const differentSeparatorPos = numbersToSum.indexOf(haveMoreThanOneSeparator)
        error += `'${separator}' expected but '${haveMoreThanOneSeparator}' found at position ${differentSeparatorPos}.\n`
    }

    return error
}

const extractNumbersAndSeparator = (inTheOperation: string) => {
    let separator: RegExp|string = /[,\n]/
    let operationToIterate = []
    let numbersToSum = inTheOperation
    let errorSeparator = ""

    if (inTheOperation.startsWith("//")) {
        operationToIterate = numbersToSum.split(/[\n]/)
        separator = operationToIterate[0].replace("//", "")
        numbersToSum = operationToIterate[1]
        errorSeparator += checkIfTheNumbersHaveMoreThanOneSeparator(numbersToSum, separator);
    }

    return [numbersToSum, separator, errorSeparator];
}

const checkNegativeNumbersIn = (theOperationToIterate: string[]) => {
    const negativeNumbers = theOperationToIterate.filter(number => parseFloat(number) < 0)
    let error = ""
    if (negativeNumbers.length > 0) {
        const negativeNumbersJoined = negativeNumbers.join(",").trim()
        error += `Negative not allowed : ${negativeNumbersJoined}\n`
    }

    return error
}

export const add = (theOperation: string) => {
    const [numbersToSum, separator, errorSeparator] = extractNumbersAndSeparator(theOperation);
    const numbersToString = numbersToSum as string;
    const theOperationInThisToIterate = numbersToString.split(separator)
    let errors = ""

    errors += checkNegativeNumbersIn(theOperationInThisToIterate)
    errors += checkIfSeparatorIsInTheLastPositionOf(theOperation)
    errors += checkIfTwoSeparatorsAreTogetherIn(theOperation)
    errors += errorSeparator

    if(errors !== "") {
        throw new Error(errors)
    }

    const sum = theOperationInThisToIterate.reduce((previousNumber, currentNumber) => previousNumber + parseFloat(currentNumber), 0)

    return numbersToSum === "" ? "0" : sum.toString()
}
