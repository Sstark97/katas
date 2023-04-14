function areEmptyParameters(chain: string, replacements: {}) {
    return chain === "" || Object.keys(replacements).length === 0;
}

function templateEngineConverterFrom(chain: string, replacements: {}) {
    if(areEmptyParameters(chain, replacements)) {
        return chain;
    }

    const variableToFind = /\$\{(.*?)\}/
    const [textToReplace, key ] = chain.match(variableToFind)
    const replacementValue = replacements[key]

    return chain.replace(textToReplace, replacementValue)
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
})