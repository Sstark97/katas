interface UserRepository {
    save(email: string): void
    getUsers(): string[]
}

export class FakeDataBase implements UserRepository {
    private users: string[] = []
    save(email: string) {
        this.users.push(email)
    }

    getUsers() {
        return this.users
    }
}

export class UserService {
    constructor(private readonly userRepository: UserRepository) {}
    save(email: string) {
        if(email !== "") {
            this.userRepository.save(email)
        }
    }

    getUsers() {
        return this.userRepository.getUsers()
    }
}