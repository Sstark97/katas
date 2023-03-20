describe('Word wrap',() => {
    it("return the same string if it is empty", () => {
        expect(wrap("", 1)).toBe("")
    })
});