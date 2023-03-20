import { wrap } from "../core/wrap";

describe('Word wrap',() => {
    it("return the same string if it is empty", () => {
        expect(wrap("", 1)).toBe("")
    })

    it("throw an error if columnNumber it´s negative", () => {
        expect(() => wrap("hello", -2)).toThrow("Error: columnNumber must be a positive number and it is: -2")
    })

    it("return the string with column number as line breaks", () => {
        expect(() => wrap("hello", 2)).toBe("he\nllo")
    })
});