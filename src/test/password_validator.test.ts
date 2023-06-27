import {
    passwordContainsLowerCase,
    passwordHaveTheMinimumCharacters,
    passwordValidator
} from "../core/password_validator";

describe("Password validator should", () => {
    it("check all security rules", () => {
        expect(passwordValidator("Pa5s_ord")).toBeTruthy()
    })

    it("check if contains at least eight characters", () => {
        expect(passwordHaveTheMinimumCharacters("password")).toBeTruthy()
    })

    it("check if contains at least one lowercase", () => {
        expect(passwordContainsLowerCase("password")).toBeTruthy()
    })
})