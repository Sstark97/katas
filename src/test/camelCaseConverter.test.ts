import {camelCaseConverter} from "../core/camelCaseConverter";

describe("Camel Case Converter", () => {
    it("with empty text gives empty", () => {
        expect(camelCaseConverter("")).toBe("")
    })

    it("given a word with the first letter in uppercase, it gives the same word", () => {
      expect(camelCaseConverter("Foo")).toBe("Foo")
    })
})