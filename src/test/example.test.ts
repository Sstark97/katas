import { saidHello} from "../core/example";

describe("Hello", () => {
    it("world!", () => {
        expect(saidHello("world")).toBe("Hello world!")
    })
})