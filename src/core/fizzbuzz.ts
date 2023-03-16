const whoFizzBuzzElementIs = (num: number) => {
    if (num % 3 === 0) {
        return "fizz"
    } else if (num % 5 === 0) {
        return "buzz"
    }
    return num
}

export const fizzbuzz = () => {
    const arr = Array.from(Array(100).keys()).map(num => num + 1)

    return arr.map(num => whoFizzBuzzElementIs(num))
};