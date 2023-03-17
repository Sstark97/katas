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

export const add = (theOperation: string) => {
    checkIfSeparatorIsInTheLastPositionOf(theOperation);
    checkIfTwoSeparatorsAreTogetherIn(theOperation);

    const theOperationInThisToIterate = theOperation.split(/[,\n]/)
    const sum = theOperationInThisToIterate.reduce((previousNumber, currentNumber) => previousNumber + parseFloat(currentNumber), 0)

    return theOperation === "" ? "0" : sum.toString()
}