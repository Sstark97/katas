import {passwordValidator} from "../core/password_validator";

describe("Password validator should", () => {
    it("check all security rules", () => {
        expect(passwordValidator("Pa5s_ord")).toBeTruthy()
    })
})