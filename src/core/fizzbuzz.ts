export const whoFizzBuzzElementIs = (num: number) => {
    const numberStringify = num.toString();
    const isDivisibleByThree = num % 3 === 0
    const isDivisibleByFive = num % 5 === 0
    let fizzbuzz = ""

    if (isDivisibleByThree) {
        fizzbuzz += "fizz"
    }

    if(numberStringify.includes("3")) {
        fizzbuzz += "fizz"
    }

    if (isDivisibleByFive) {
        fizzbuzz += "buzz"
    }

    if(numberStringify.includes("5")) {
        fizzbuzz += "buzz"
    }

    return fizzbuzz === "" ? num : fizzbuzz
}

export const fizzbuzz = () => {
    const arr = Array.from(Array(100).keys()).map(num => num + 1)
    const fizzBuzzResult: (string | number)[] = arr.map(num => whoFizzBuzzElementIs(num))

    return fizzBuzzResult
};