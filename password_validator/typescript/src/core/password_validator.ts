const MINIMUM_CHARACTERS: number = 8;

export function passwordValidator(password: string) {
    return passwordHaveTheMinimumCharacters(password) && passwordContainsUpperCase(password)
        && passwordContainsLowerCase(password) && passwordContainsNumbers(password)
        && passwordContainsUnderScore(password);
}

export function passwordHaveTheMinimumCharacters(password: string) {
    return password.length === MINIMUM_CHARACTERS;
}

export function passwordContainsLowerCase(password: string) {
    return password.match(/[a-z]+/);
}

export function passwordContainsUpperCase(password: string) {
    return password.match(/[A-Z]+/);
}

export function passwordContainsUnderScore(password: string) {
    return password.match(/_+/);
}

export function passwordContainsNumbers(password: string) {
    return password.match(/[0-9]+/);
}