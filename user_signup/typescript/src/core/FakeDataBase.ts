import { UserRepository } from "@core/UserRepository";

export class FakeDataBase implements UserRepository {
    private users: string[] = []
    save(email: string) {
        this.users.push(email)
    }

    getUsers() {
        return this.users
    }

    getUserByEmail(email: string){
        return ""
    }
}
