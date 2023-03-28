import { UserRepository } from "@core/UserRepository";

export class UserService {
    constructor(private readonly userRepository: UserRepository) {}

    save(email: string) {
        if (email !== "") {
            this.userRepository.save(email)
        }

        if (email && !email.match(/^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/)) {
            throw new Error(`${email} not have the email format`)
        }
    }

    getUsers() {
        return this.userRepository.getUsers()
    }
}