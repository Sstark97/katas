function templateEngineConverterFrom(chain: string, keysToReplace: {}) {
    return "";
}

describe("Template Engine", () => {
    it("empty string are allowed", () => {
        expect(templateEngineConverterFrom("", {})).toBe("")
    })

    it("chain is not modified by empty keys", () => {
        expect(templateEngineConverterFrom("irrelevant text", {})).toBe("irrelevant text")
    })
})