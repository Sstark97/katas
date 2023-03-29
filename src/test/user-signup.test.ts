import { FakeDataBase } from "../core/FakeDataBase"
import {UserService} from "../core/UserService";

describe("Sign-up", () => {
    it("not add user if email it´s empty", () => {
        const fakeDb = new FakeDataBase()
        const service = new UserService(fakeDb)
        const spy = jest.spyOn(service, "saveUserInRepository");
        service.saveUserInRepository("")

        const users = service.getUsersFromRepository()

        expect(spy).toHaveBeenCalled()
        expect(users.length).toBe(0)
    })

    it("throws an error message if email not have the correct format", () => {
        const fakeDb = new FakeDataBase()
        const service = new UserService(fakeDb)
        const spy = jest.spyOn(service, "saveUserInRepository")
        const email = "notAnEmail.com"

        expect(() => service.saveUserInRepository(email)).toThrow(`${email} not have the email format`)
        expect(spy).toHaveBeenCalled()
    })

    it("save user in repository if email have the correct format", () => {
        const fakeDb = new FakeDataBase()
        const service = new UserService(fakeDb)
        const spy = jest.spyOn(service, "saveUserInRepository")
        const email = "example@email.com"

        service.saveUserInRepository(email)

        const users = service.getUsersFromRepository()

        expect(spy).toHaveBeenCalled()
        expect(users[0]).toBe(email)
        expect(users.length).toBe(1)
    })
})