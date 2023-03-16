const whoFizzBuzzElementIs = (num: number) => {
    if (num % 3 === 0) {
        return "fizz"
    } else if (num % 5 === 0) {
        return "buzz"
    }
    return num
}

export const fizzbuzz = () => {
    const arr = [1, 2, 3, 4, 5];

    return arr.map(num => whoFizzBuzzElementIs(num))
};