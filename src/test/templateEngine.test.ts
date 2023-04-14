function templateEngineConverterFrom(chain: string, keysToReplace: {}) {
    if(chain === "" || Object.keys(keysToReplace).length === 0) {
        return chain;
    }

    const variableToFind = /\$\{(.*?)\}/
    const keyInChain = chain.match(variableToFind)

    return chain.replace(keyInChain[0], keysToReplace[keyInChain[1]])
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
        const keysToReplace = {
            variable: "foo"
        }

        expect(templateEngineConverterFrom(chain, keysToReplace)).toBe("This is a template with one foo")
    })
})