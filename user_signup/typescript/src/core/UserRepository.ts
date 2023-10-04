export interface UserRepository {
    save(email: string): void

    getUsers(): string[]
    getUserByEmail(email: string): string
}