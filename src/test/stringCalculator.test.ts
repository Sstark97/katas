import {add} from "../core/stringCalculator";

describe("String Calculator test", () => {
    it("should return 0 for empty string", () => {
        expect(add("")).toBe("0")
    })

    it("should return the same number if the string only contains one number", () => {
        expect(add("1")).toBe("1")
    })

    it("should return the sum of numbers contains in string separated by commas", () => {
        expect(add("1, 2")).toBe("3")
    })

    it("should return an unknow number of arguments", () => {
        expect(add("1, 2, 3")).toBe("6")
    })

    it("should return the sum of numbers contains in string separated by commas and newlines", () => {
        expect(add("1\n2, 3")).toBe("6")
    })

    it("should return error message if separators are next to each other", () => {
        expect(() => add("175.2,\n35")).toThrow("Number expected but '\n' found at position 6.")
    })

    it("should return error message if a number is missing in last position", () => {
        expect(() => add("1,3,")).toThrow("Number expected but EOF found.")
    })
})