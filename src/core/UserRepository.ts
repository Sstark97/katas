export interface UserRepository {
    save(email: string): void

    getUsers(): string[]
}