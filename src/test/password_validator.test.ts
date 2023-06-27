import {
    passwordContainsLowerCase,
    passwordContainsUnderScore,
    passwordContainsUpperCase,
    passwordHaveTheMinimumCharacters,
    passwordValidator
} from "../core/password_validator";

describe("Password validator should", () => {
    it("check all security rules", () => {
        expect(passwordValidator("Pa5s_ord")).toBeTruthy()
    })

    it("contains at least eight characters", () => {
        expect(passwordHaveTheMinimumCharacters("password")).toBeTruthy()
    })

    it("contains at least one lowercase", () => {
        expect(passwordContainsLowerCase("password")).toBeTruthy()
    })

    it("contains at least one uppercase", () => {
        expect(passwordContainsUpperCase("Password")).toBeTruthy()
    })

    it("contains at least one number", () => {
        expect(passwordContainsNumbers("p12345")).toBeTruthy()
    })

    it("contains at least one underscore", () => {
        expect(passwordContainsUnderScore("pas_word")).toBeTruthy()
    })
})