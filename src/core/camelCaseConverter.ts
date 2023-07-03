export const camelCaseConverter = (text: string) => {
    const words = text.split(/\s|-|_/)
    const capitalizedWords = words.map(word => word.charAt(0).toUpperCase() + word.slice(1))

    return capitalizedWords.join("")
}