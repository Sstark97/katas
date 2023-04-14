describe("Template Engine", () => {
    it("empty string are allowed", () => {
        expect(templateEngine("", {})).toBe("")
    })
})