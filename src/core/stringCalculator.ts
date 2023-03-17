export const add = (theOperationInThis: string) => {
    for (let i = 0; i < theOperationInThis.length; i++) {
        if (i !== 0) {
            if (theOperationInThis[i].match(/[,\n]/) && theOperationInThis[i-1].match(/[,\n]/)) {
                throw new Error(`Number expected but '${theOperationInThis[i]}' found at position ${i}.`)
            }
        }
    }
    const theOperationInThisToIterate = theOperationInThis.split(/[,\n]/)
    const sum = theOperationInThisToIterate.reduce((previousNumber, currentNumber) => previousNumber + parseFloat(currentNumber), 0)

    return theOperationInThis === "" ? "0" : sum.toString()
}