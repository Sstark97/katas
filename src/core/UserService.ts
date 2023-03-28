import { UserRepository } from "@core/UserRepository";

export class UserService {
    constructor(private readonly userRepository: UserRepository) {}

    save(email: string) {
        const isEmailNotEmpty = email !== ""
        const notHaveEmailFormat = this.checkCorrectFormOf(email)

        if (isEmailNotEmpty) {
            this.userRepository.save(email)
        }

        if (notHaveEmailFormat) {
            throw new Error(`${email} not have the email format`)
        }
    }

    private checkCorrectFormOf(email: string) {
        const emailFormat = /^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/
        return email && !email.match(emailFormat)
    }

    getUsers() {
        return this.userRepository.getUsers()
    }
}