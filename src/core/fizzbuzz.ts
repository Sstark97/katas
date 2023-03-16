export const whoFizzBuzzElementIs = (num: number) => {
    const numberStringify = num.toString();

    if (num % 15 === 0) {
        return "fizzbuzz"
    } else if (num % 3 === 0 || numberStringify.includes("3")) {
        return "fizz"
    } else if (num % 5 === 0) {
        return "buzz"
    }

    return num
}

export const fizzbuzz = () => {
    const arr = Array.from(Array(100).keys()).map(num => num + 1)
    const fizzBuzzResult: (string | number)[] = arr.map(num => whoFizzBuzzElementIs(num))

    return fizzBuzzResult
};