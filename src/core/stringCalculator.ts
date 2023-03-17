function checkIfTwoSeparatorsAreTogetherIn(theOperation: string) {
    for (let i = 1; i < theOperation.length; i++) {
        const currentElement = theOperation[i].match(/[,\n]/)
        const previousElement = theOperation[i-1].match(/[,\n]/)

        if (currentElement && previousElement) {
            throw new Error(`Number expected but '${theOperation[i]}' found at position ${i}.`)
        }
    }
}

export const add = (theOperation: string) => {
    checkIfTwoSeparatorsAreTogetherIn(theOperation);
    const theOperationInThisToIterate = theOperation.split(/[,\n]/)
    const sum = theOperationInThisToIterate.reduce((previousNumber, currentNumber) => previousNumber + parseFloat(currentNumber), 0)

    return theOperation === "" ? "0" : sum.toString()
}