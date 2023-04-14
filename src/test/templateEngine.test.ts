function templateEngineConverterFrom(chain: string, keysToReplace: {}) {
    return "";
}

describe("Template Engine", () => {
    it("empty string are allowed", () => {
        expect(templateEngineConverterFrom("", {})).toBe("")
    })
})