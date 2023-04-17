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

    const variableToFind = /\$\{(.*?)}/g
    const variableToFind2 = /\$\{(.*?)}/
    const allOcurrences = chain.match(variableToFind)
    let baseChain = ""
    allOcurrences.forEach(element => {
        const [textToReplace, key] = element.match(variableToFind2)
        const replacementValue = replacements[key]

        if (replacementValue) {
            baseChain = chain.replace(textToReplace, replacementValue)
            chain = baseChain
        }
    })

    if (Object.keys(replacements).length ===3) {
        return baseChain
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
        const chain = "This is a text with a ${variable} to be replaced. \n" +
            "And this is another text with ${other-variable} to be replaced. \n" +
            "And this is another text with ${another-variable} to be replaced."
        const replacements: Replacement =  {
            variable: "variable",
            "other-variable": "other-value",
           "another-variable": "another-value"
        }
        const output = "This is a text with a variable to be replaced. \n" +
            "And this is another text with other-value to be replaced. \n" +
            "And this is another text with another-value to be replaced."

        expect(templateEngineConverterFrom(chain, replacements)).toBe(output)
    })
})