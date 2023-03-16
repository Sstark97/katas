export const fizzbuzz = () => {
    const arr = [1, 2, 3, 4, 5];
    const fizzBuzzResult: (string | number)[] = arr.map(num => {
        if(num % 3 === 0) {
            return "fizz"
        } else if(num % 5 === 0) {
            return "buzz"
        }
        return num
    })

    return fizzBuzzResult
};