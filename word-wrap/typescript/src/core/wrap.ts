const checkIfIsNegative = (columnNumber: number) => {
    if (columnNumber < 0) {
        throw new Error(`Error: columnNumber must be a positive number and it is: ${columnNumber}`)
    }
}

export const wrap = (text: string, columnNumber: number) => {
    checkIfIsNegative(columnNumber)

    let textWithLineBreaks = ""

    for (let i = 0; i < text.length; i += columnNumber) {
        textWithLineBreaks += `${text.substring(i, i + columnNumber)}\n`
    }

    return textWithLineBreaks.slice(0, -1)
}