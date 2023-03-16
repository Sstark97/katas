import { fizzbuzz } from "../core/fizzbuzz";

describe('Fizzbuzz Test', () => {
    it("check that number 3 returns fizz", () => {
        const fizzbuzzResult = fizzbuzz()

        expect(fizzbuzzResult[2]).toBe("fizz")
    })
});