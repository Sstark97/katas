import {camelCaseConverter} from "../core/camelCaseConverter";

describe("Camel Case Converter", () => {
    it("with empty text gives empty", () => {
        expect(camelCaseConverter("")).toBe("")
    })

    it("given a word with the first letter in uppercase, it gives the same word", () => {
      expect(camelCaseConverter("Foo")).toBe("Foo")
    })

    it("given words with the first letter in upper case separated by spaces, it gives the words joined", () => {
        expect(camelCaseConverter("Foo Bar")).toBe("FooBar")
    })

    it("given a text that contains all words with the first letter in upper case separated by dashes, it gives the words joined", () => {
        expect(camelCaseConverter("Foo_Bar-Foo")).toBe("FooBarFoo")
    })

    it("for a word with the first letter, it gives the same word capitalize", () => {
        expect(camelCaseConverter("foo")).toBe("Foo")
    })
})