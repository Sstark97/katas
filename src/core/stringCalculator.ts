export const add = (theOperationInThis: string) => {
    const theOperationInThisToIterate = theOperationInThis.split((","))
    const sum = theOperationInThisToIterate.reduce((previousNumber, currentNumber) => previousNumber + parseInt(currentNumber), 0)

    return theOperationInThis === "" ? "0" : sum.toString()
}