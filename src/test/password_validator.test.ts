import {passwordValidator} from "../core/password_validator";

function passwordHaveTheMinimumCharacters(password: string) {
    return password.length === 8;
}

describe("Password validator should", () => {
    it("check all security rules", () => {
        expect(passwordValidator("Pa5s_ord")).toBeTruthy()
    })

    it("check if contains at least eight characters", () => {
        expect(passwordHaveTheMinimumCharacters("password")).toBeTruthy()
    })
})