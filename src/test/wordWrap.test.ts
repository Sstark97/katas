import { wrap } from "../core/wrap";

describe('Word wrap',() => {
    it("return the same string if it is empty", () => {
        expect(wrap("", 1)).toBe("")
    })

    it("throw an error if columnNumber it´s negative", () => {
        expect(() => wrap("hello", -2)).toThrow("Error: columnNumber must be a positive number and it is: -2")
    })
});