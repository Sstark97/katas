function templateEngine(s: string, param2: {}) {
    return "";
}

describe("Template Engine", () => {
    it("empty string are allowed", () => {
        expect(templateEngine("", {})).toBe("")
    })
})