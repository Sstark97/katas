const capitalize = (word: string) => word.charAt(0).toUpperCase() + word.slice(1)

export const camelCaseConverter = (text: string) => {
    const words = text.split(/\s|-|_/)
    const capitalizedWords = words.map(word => capitalize(word))

    return capitalizedWords.join("")
}