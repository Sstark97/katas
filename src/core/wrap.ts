export const wrap = (text: string, columnNumber: number) => {
    if(columnNumber < 0) {
        throw new Error(`Error: columnNumber must be a positive number and it is: ${columnNumber}`)
    }

    return text;
}