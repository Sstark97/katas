import { fizzbuzz } from "../core/fizzbuzz";

describe('Fizzbuzz Test', () => {
    it("check that number 3 returns fizz", () => {
        const fizzbuzzResult = fizzbuzz()
        const fizz = fizzbuzzResult.find((num, pos) => num === "fizz" && (pos + 1) % 3 === 0)

        expect(fizz).toBe("fizz")
    })
});