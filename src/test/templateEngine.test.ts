function areEmptyParameters(chain: string, replacements: {}) {
    return chain === "" || Object.keys(replacements).length === 0;
}

interface Replacement {
    [key: string]: string
}

function templateEngineConverterFrom(chain: string, replacements: Replacement) {
    if(areEmptyParameters(chain, replacements)) {
        return chain;
    }

    const variableToFind = /\$\{(.*?)\}/
    const [textToReplace, key ] = chain.match(variableToFind)
    const replacementValue = replacements[key]

    if (replacementValue) {
        return chain.replace(textToReplace, replacementValue)
    }

    throw new Error("Text doesn´t match replacements keys")
}

describe("Template Engine", () => {
    it("empty string are allowed", () => {
        expect(templateEngineConverterFrom("", {})).toBe("")
    })

    it("chain is not modified by empty keys", () => {
        const chain = "irrelevant text"
        expect(templateEngineConverterFrom(chain, {})).toBe(chain)
    })

    it("transform chain with key values", () => {
        const chain: string ="This is a template with one ${variable}"
        const replacements = {
            variable: "foo"
        }

        expect(templateEngineConverterFrom(chain, replacements)).toBe("This is a template with one foo")
    })

    it("text doesn´t match replacements keys", () => {
        const chain: string ="This is a template with one ${variable}"
        const replacements = {
            notInText: "foo"
        }

        expect(() => templateEngineConverterFrom(chain, replacements)).toThrow("Text doesn´t match replacements keys")
    })

    it('multiple keys are allowed', () => {
        const chain = - "This is a text with a ${variable} to be replaced. \n" +
            "And this is another text with ${other-variable} to be replaced. \n" +
            "And this is another text with ${another-variable} to be replaced."
        const replacements: Replacement =  {
            variable: "value",
            otherVariable: "other-value",
            anotherVariable: "another-value"
        }
        const output = "This is a text with a variable to be replaced. " +
            "And this is another text with other-value to be replaced. " +
            "And this is another text with another-value to be replaced."

        expect(templateEngineConverterFrom(chain, replacements)).toBe(output)
    })
})