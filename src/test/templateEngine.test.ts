function templateEngineConverterFrom(chain: string, keysToReplace: {}) {
    return chain;
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