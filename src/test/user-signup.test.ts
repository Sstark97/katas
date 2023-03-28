import { FakeDataBase } from "../core/fake-data.base";

describe("Sign-up", () => {
    it("not add user if email it´s empty", () => {
        const database = new FakeDataBase()

        expect(database.save("")).toHaveBeenCalled()
    })
})