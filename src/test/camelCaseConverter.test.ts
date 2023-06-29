import {camelCaseConverter} from "../core/camelCaseConverter";

describe("Camel Case Converter", () => {
    it("with empty text gives empty", () => {
        expect(camelCaseConverter("")).toBe("")
    })
})