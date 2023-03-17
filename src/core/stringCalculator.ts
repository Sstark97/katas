export const add = (theOperationInThis: string) => {
    const theOperationInThisToIterate = theOperationInThis.split(/[,\n]/)
    const sum = theOperationInThisToIterate.reduce((previousNumber, currentNumber) => previousNumber + parseFloat(currentNumber), 0)

    return theOperationInThis === "" ? "0" : sum.toString()
}