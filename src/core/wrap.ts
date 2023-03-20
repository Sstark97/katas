const checkIfIsNegative = (columnNumber: number) => {
    if (columnNumber < 0) {
        throw new Error(`Error: columnNumber must be a positive number and it is: ${columnNumber}`)
    }
}

export const wrap = (text: string, columnNumber: number) => {
    checkIfIsNegative(columnNumber);

    return text;
}