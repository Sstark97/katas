const MINIMUM_CHARACTERS: number = 8;

export function passwordValidator(password: string) {
    return undefined;
}

export function passwordHaveTheMinimumCharacters(password: string) {
    return password.length === MINIMUM_CHARACTERS;
}