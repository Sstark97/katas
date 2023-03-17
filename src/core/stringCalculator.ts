export const add = (theOperationInThis: string) => {
    const theOperationInThisToIterate = theOperationInThis.split((","))
    let sum = 0

    for (let i = 0; i < theOperationInThisToIterate.length; i++) {
        sum += parseInt(theOperationInThisToIterate[i])
    }

    return theOperationInThis === "" ? "0" : sum.toString()
}