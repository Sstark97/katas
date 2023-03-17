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
})