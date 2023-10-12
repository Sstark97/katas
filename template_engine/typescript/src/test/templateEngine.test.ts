import { templateEngineConverterFrom } from "../core/templateEngine"
import type { Replacement } from "../core/Replacement"

describe("Template Engine", () => {
    it("empty string are allowed", () => {
        expect(templateEngineConverterFrom("", {})).toBe("")
    })

    it("text is not modified by empty keys", () => {
        const text = "irrelevant text"
        expect(templateEngineConverterFrom(text, {})).toBe(text)
    })

    it("transform text with key values", () => {
        const text: string ="This is a template with one ${variable}"
        const replacements = {
            variable: "foo"
        }

        expect(templateEngineConverterFrom(text, replacements)).toBe("This is a template with one foo")
    })

    it("text doesn't match replacements keys", () => {
        const text: string ="This is a template with one ${variable}"
        const replacements = {
            notInText: "foo"
        }

        expect(() => templateEngineConverterFrom(text, replacements)).toThrow("Text doesn't match replacements keys")
    })

    it('multiple keys are allowed', () => {
        const text = "This is a text with a ${variable} to be replaced. \n" +
            "And this is another text with ${otherVariable} to be replaced. \n" +
            "And this is another text with ${anotherVariable} to be replaced."
        const replacements: Replacement =  {
            variable: "variable",
            otherVariable: "other-value",
            anotherVariable: "another-value"
        }
        const output = "This is a text with a variable to be replaced. \n" +
            "And this is another text with other-value to be replaced. \n" +
            "And this is another text with another-value to be replaced."

        expect(templateEngineConverterFrom(text, replacements)).toBe(output)
    })
})