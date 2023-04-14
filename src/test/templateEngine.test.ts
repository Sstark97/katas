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

    const variableToFind = /\$\{(.*?)\}/g
    const variableToFind2 = /\$\{(.*?)\}/
    const allOcurrences = chain.match(variableToFind)
    let baseChain = chain
    allOcurrences.forEach(element => {
        const [textToReplace, key] = element.match(variableToFind2)

        const replacementValue = replacements[key]
        console.log('key', key)
        console.log('textToReplace', textToReplace)
        console.log('replacementValue', replacementValue)
        if (replacementValue) {
            baseChain.replace(textToReplace, replacementValue)
            console.log('baseChain----', baseChain)
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
        const chain = "This is a text with a ${variable} to be replaced. \nAnd this is another text with ${otherVariable} to be replaced. \nAnd this is another text with ${anotherVariable} to be replaced."
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